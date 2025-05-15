package studiplayer.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.application.Platform;

import studiplayer.audio.*;

import java.io.File;
import java.net.URL;

public class Player extends Application {
	// final pentru a scoate in evidenta faptul ca variabila statica este constanta
	public static final String DEFAULT_PLAYLIST = "playlists/DefaultPlayList.m3u";

	private static final String PLAYLIST_DIRECTORY = "playlists";

	private static final String INITIAL_PLAY_TIME_LABEL = "00:00";

	private static final String NO_CURRENT_SONG = " - ";

	private PlayList playList;

	private boolean useCertPlayList = false;

	public Player() {
		// default constructor
	}

	public void setUseCertPlayList(boolean value) {
		this.useCertPlayList = value;
	}

	// Schaltflachen für Wiedergabe-Steuerung
	private Button playButton;
	private Button pauseButton;
	private Button stopButton;
	private Button nextButton;

	private Button filterButton;

	// atribute labels
	private Label playListLabel; // afiseaza numele playlistului curent
	private Label playTimeLabel; // afiseaza timpul de redare
	private Label currentSongLabel; // afiseaza melodia curenta

	private ChoiceBox<SortCriterion> sortChoiceBox;
	private TextField searchTextField;

	private SongTable songTable;

	private PlayerThread playerThread;
	private TimerThread timerThread;

	@Override
	public void start(Stage stage) throws Exception {
		// cretam un titlu
		stage.setTitle("APA Player");

		// create a main pane
		BorderPane mainPane = new BorderPane();

		Scene scene = new Scene(mainPane, 600, 400);
		stage.setScene(scene);

		// Steuerelemente erzeugen und in das untere Layout einfügen
		mainPane.setBottom(createControlButtons());
		mainPane.setTop(createSongInfoGrid());

		// Auswahl wenn keine PrüfungsPlaylist verwendet wird
		if (!useCertPlayList) {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open M3U File");
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("M3U FILES", "*.m3u"));

			File initialDirectory = new File("playlists");
			if (initialDirectory.exists()) {
				fileChooser.setInitialDirectory(initialDirectory);
			}

			File file = fileChooser.showOpenDialog(stage);

			if (file != null) {
				loadPlayList(file.getPath());
			} else {
				loadPlayList(DEFAULT_PLAYLIST);
			}

			songTable = new SongTable(playList);
			mainPane.setCenter(songTable);

		} else {
			loadPlayList("playlists/playList.cert.m3u");
			songTable = new SongTable(playList);
			mainPane.setCenter(songTable);
		}

		// show stage
		stage.show();
	}

	// Erstellt eine Schaltfläche mit Icon
	private Button createButton(String iconfile) {
		Button button = null;
		try {
			URL url = getClass().getResource("/icons/" + iconfile);
			Image icon = new Image(url.toString());
			ImageView imageView = new ImageView(icon);
			imageView.setFitHeight(20);
			imageView.setFitWidth(20);
			button = new Button("", imageView);
			button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			button.setStyle("-fx-background-color: #fff;");
		} catch (Exception e) {
			System.out.println("Image " + "icons/" + iconfile + " not found!");
			System.exit(-1);
		}
		return button;
	}

	// Erstellt das obere Informationsfeld (Playlist, Song, Zeit usw)
	private GridPane createSongInfoGrid() {
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(5);
		grid.setPadding(new Insets(5));

		// create labels
		Label playListTitleLabel = new Label("Playlist: ");
		playListLabel = new Label("No playlist loaded");

		Label currentSongTitleLabel = new Label("Current Song: ");
		currentSongLabel = new Label(NO_CURRENT_SONG);

		Label playTimeTitleLabel = new Label("Play Time: ");
		playTimeLabel = new Label(INITIAL_PLAY_TIME_LABEL);

		grid.add(playListTitleLabel, 0, 0);
		grid.add(playListLabel, 1, 0);
		grid.add(currentSongTitleLabel, 0, 1);
		grid.add(currentSongLabel, 1, 1);
		grid.add(playTimeTitleLabel, 0, 2);
		grid.add(playTimeLabel, 1, 2);

		// search & sort hinzugefügt
		Label searchLabel = new Label("Search:");
		searchTextField = new TextField();
		Label sortLabel = new Label("Sort:");
		sortChoiceBox = new ChoiceBox<>();
		sortChoiceBox.getItems().addAll(SortCriterion.values());
		sortChoiceBox.setValue(SortCriterion.DEFAULT);

		grid.add(searchLabel, 0, 3);
		grid.add(searchTextField, 1, 3);
		grid.add(sortLabel, 0, 4);
		grid.add(sortChoiceBox, 1, 4);

		return grid;
	}

	public void loadPlayList(String pathname) {
		try {
			if (pathname == null || pathname.isEmpty()) {
				pathname = DEFAULT_PLAYLIST;
			}
			PlayList loaded = new PlayList(pathname);
			playList = loaded;
			System.out.println("Loaded playlist: " + pathname);
			if (songTable != null) {
				songTable.refreshSongs();
			}

		} catch (Exception e) {
			System.err.println("Error Loading playlist: " + e.getMessage());
			playList = new PlayList();
		}
	}

	private void startThreads(boolean onlyTimer) {
		if (timerThread == null) {
			timerThread = new TimerThread();
			timerThread.start();
		}
		if (!onlyTimer && playerThread == null) {
			playerThread = new PlayerThread();
			playerThread.start();
		}
	}

	private void terminateThreads(boolean onlyTimer) {
		if (timerThread != null) {
			timerThread.terminate();
			timerThread = null;
		}
		if (!onlyTimer && playerThread != null) {
			playerThread.terminate();
			playerThread = null;
		}
	}

	private void updateButtonStatesDuringPlayback() {
		playButton.setDisable(true);
		pauseButton.setDisable(false);
		stopButton.setDisable(false);
	}

	private void playNextSong() {
		if (playList != null && playList.size() > 0) {
			AudioFile currentSong = playList.currentAudioFile();
			if (currentSong != null) {
				System.out.println("Switching to next audio file");
			}
			playList.nextSong();
			updateButtonStatesDuringPlayback();
			startThreads(false);
		}
	}

	// Spielt den aktuellen Song ab
	private void playCurrentSong() {
		if (playList != null && playList.size() > 0) {
			AudioFile currentSong = playList.currentAudioFile();
			if (currentSong != null) {
				try {
					currentSong.play();
					songTable.selectSong(currentSong);
				} catch (Exception e) {
					System.err.println("Fehler beim Abspielen: " + e.getMessage());
				}
			}
		}
	}

	private class PlayerThread extends Thread {
		private boolean stopped = false;

		public void terminate() {
			stopped = true;
		}

		@Override
		public void run() {
			if (playList != null && playList.size() > 0) {
				AudioFile currentSong = playList.currentAudioFile();
				if (currentSong != null) {
					songTable.selectSong(currentSong);
					try {
						currentSong.play();
						while (!stopped && playList.iterator().hasNext()) {
							if (!currentSong.equals(playList.currentAudioFile())) {
								Platform.runLater(() -> playNextSong());
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
								}
								currentSong = playList.currentAudioFile();
							}
						}
					} catch (Exception e) {
					}
				}
			}
		}
	}

	private class TimerThread extends Thread {
		private boolean stopped = false;

		public void terminate() {
			stopped = true;
		}

		@Override
		public void run() {
			while (!stopped) {
				if (playList != null && playList.size() > 0) {
					AudioFile currentSong = playList.currentAudioFile();
					if (currentSong != null) {
						Platform.runLater(() -> playTimeLabel.setText(currentSong.formatPosition()));
					}
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					if (stopped)
						break;
				}
			}
		}
	}

	// Erstellt die Steuerknopfe (Play, Pause, etc)
	private HBox createControlButtons() {
		HBox buttonBox = new HBox(10);
		buttonBox.setAlignment(Pos.CENTER);
		buttonBox.setPadding(new Insets(10));

		playButton = createButton("play.jpg");
		pauseButton = createButton("pause.jpg");
		stopButton = createButton("stop.jpg");
		nextButton = createButton("next.jpg");
		filterButton = createButton("add.jpg");

		playButton.setOnAction(e -> {
			terminateThreads(false);
			playButton.setDisable(true);
			pauseButton.setDisable(false);
			stopButton.setDisable(false);
			startThreads(false);
		});

		pauseButton.setOnAction(e -> {
			AudioFile current = playList.currentAudioFile();
			if (current != null) {
				current.togglePause();
			}
		});

		stopButton.setOnAction(e -> {
			terminateThreads(false);
			Platform.runLater(() -> playTimeLabel.setText(INITIAL_PLAY_TIME_LABEL));
			stopButton.setDisable(true);
			pauseButton.setDisable(true);
			playButton.setDisable(false);
		});

		nextButton.setOnAction(e -> playNextSong());

		filterButton.setOnAction(e -> {
			String text = searchTextField.getText();
			SortCriterion crit = sortChoiceBox.getValue();
			playList.setSearch(text);
			playList.setSortCriterion(crit);
			songTable.refreshSongs();
		});

		buttonBox.getChildren().addAll(playButton, pauseButton, stopButton, nextButton, filterButton);
		playButton.setDisable(false);
		pauseButton.setDisable(true);
		stopButton.setDisable(true);
		nextButton.setDisable(false);
		filterButton.setDisable(false);

		return buttonBox;
	}

	public static void main(String[] args) {
		launch(args);
	}
}