// package player;

public abstract class AudioFile {

	protected String pathname; // Calea completa catre fisierul audio (ex: audiofiles/beethoven.mp3)
	protected String filename; // Numele fisierului fara cale
	protected String author; // Autorul piesei
	protected String title; // Titlul piesei

	// Constructor implicit – initializeaza toate campurile cu stringuri goale
	public AudioFile() {
		this.pathname = "";
		this.filename = "";
		this.author = "";
		this.title = "";
	}

	// Constructor cu parametru – primeste path, valideaza si extrage informatii
	public AudioFile(String path) {
		parsePathname(path);

		java.io.File file = new java.io.File(this.pathname); // foloseste pathname normalizat
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new RuntimeException("File not readable: " + this.pathname);
		}

		parseFilename(this.filename);
	}

	// Normalizeaza calea fisierului in functie de OS
	public void parsePathname(String path) {
		this.pathname = "";
		this.filename = "";

		if (path == null || path.trim().isEmpty()) {
			return;
		}

		path = path.trim();
		path = path.replaceAll("[/\\\\]+", System.getProperty("file.separator"));

		String separator = System.getProperty("file.separator");
		String normalizedPath = path;

		boolean hadTrailingSlash = path.endsWith("/") || path.endsWith("\\");

		if (isWindows()) {
			normalizedPath = normalizedPath.replace('/', '\\');
			while (normalizedPath.contains("\\\\"))
				normalizedPath = normalizedPath.replace("\\\\", "\\");
		} else {
			normalizedPath = normalizedPath.replace('\\', '/');

			if (normalizedPath.length() >= 2 && Character.isLetter(normalizedPath.charAt(0))
					&& normalizedPath.charAt(1) == ':') {

				char driveLetter = normalizedPath.charAt(0);
				normalizedPath = "/" + driveLetter + normalizedPath.substring(2);
			}

			while (normalizedPath.contains("//"))
				normalizedPath = normalizedPath.replace("//", "/");
		}

		if (hadTrailingSlash && !normalizedPath.endsWith(separator)) {
			normalizedPath += separator;
		}

		this.pathname = normalizedPath;

		int lastSeparatorIndex = isWindows() ? normalizedPath.lastIndexOf("\\") : normalizedPath.lastIndexOf("/");

		if (lastSeparatorIndex != -1 && lastSeparatorIndex < normalizedPath.length() - 1) {
			this.filename = normalizedPath.substring(lastSeparatorIndex + 1).trim();
		} else if (lastSeparatorIndex == -1) {
			this.filename = normalizedPath.trim();
		}
	}

	// Extrage autorul si titlul din numele fisierului
	public void parseFilename(String input) {
		this.author = "";
		this.title = "";

		if (input != null && input.equals(" - ")) {
			return; // gol intentional
		}

		if (input == null || input.trim().isEmpty()) {
			return;
		}

		input = input.trim();

		if (input.equals("-")) {
			this.title = "-";
			return;
		}

		if (input.equals(" - ")) {
			this.author = "";
			this.title = "";
			return;
		}

		int lastDotIndex = input.lastIndexOf('.');
		if (lastDotIndex != -1) {
			input = input.substring(0, lastDotIndex);
		}

		int separatorIndex = input.indexOf(" - ");
		if (separatorIndex != -1) {
			String possibleAuthor = input.substring(0, separatorIndex).trim();
			String possibleTitle = input.substring(separatorIndex + 3).trim();

			this.author = possibleAuthor;
			this.title = possibleTitle;
		} else {
			this.title = input.trim(); // fallback – tratam tot ca titlu
		}
	}

	public String getPathname() {
		return this.pathname;
	}

	public String getFilename() {
		return this.filename;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getTitle() {
		return this.title;
	}

	// Formateaza informatia ptr. afisare
	@Override
	public String toString() {
		if ((author == null || author.trim().isEmpty()) && (title == null || title.trim().isEmpty())) {
			return filename.trim(); // fallback
		}

		if (author == null || author.trim().isEmpty()) {
			return title.trim(); // nur den Titel zurückgeben
		}

		if (title == null || title.trim().isEmpty()) {
			return author.trim(); // nur den Autor zurückgeben
		}

		return author.trim() + " - " + title.trim(); // vollständiges Format
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !(obj instanceof AudioFile))
			return false;

		AudioFile other = (AudioFile) obj;
		return this.toString().trim().equals(other.toString().trim());
	}

	@Override
	public int hashCode() {
		return pathname != null ? pathname.hashCode() : 0;
	}

	
	private boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().indexOf("win") >= 0;
	}

	// Metode abstracte – trebuie implementate in clasele concrete
	public abstract void play();

	public abstract void togglePause();

	public abstract void stop();

	public abstract String formatDuration();

	public abstract String formatPosition();
}