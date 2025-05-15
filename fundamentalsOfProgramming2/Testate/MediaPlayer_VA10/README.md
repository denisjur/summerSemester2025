# 🎵 MediaPlayer_VA10 – JavaFX MP3/WAV Player

Dies ist ein grafischer Musik-Player mit JavaFX, der `.mp3`, `.wav` sowie `.m3u`-Playlists abspielen kann.  
Er wurde als Teil einer Programmieraufgabe entwickelt (VA10) und unterstützt:

- Play / Pause / Stop / Next
- Sortierung (Titel, Autor, Album, Dauer)
- Live-Suche
- Unterstützung für `.m3u`-Playlisten

---

## ✅ Voraussetzungen

- Java 17 oder neuer
- [JavaFX SDK 21.0.7]
  (bereits eingerichtet unter `/home/.../JavaFxSDK24.01/javafx-sdk-21.0.7`)

---

## ▶️ Ausführen in Eclipse

1. Öffne Eclipse und importiere das Projekt `MediaPlayer_VA10`
2. Navigiere zu `src/studiplayer/ui/Player.java`
3. Rechtsklick auf `Player.java` → Run As → Java Application

---

## ⚙️ VM-Argumente setzen (nur beim ersten Start)

1. Menü: Run → Run Configurations...
2. Wähle links Java Application → Player (oder erstell eine neue)
3. Gehe zum Tab Arguments
4. Im Feld VM arguments einfügen:

```
--module-path "/home/.../JavaFxSDK24.01/javafx-sdk-21.0.7/lib" --add-modules javafx.controls,javafx.fxml
```


