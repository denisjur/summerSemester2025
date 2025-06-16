
# Configurare JavaFX cu variabilă de mediu – Pași compleți

Programul a fost plasat într-un folder dedicat. Pentru a evita scrierea repetată a căii către JavaFX SDK, am creat o variabilă de mediu permanentă în sistem.

## Pași:

1. **Deschide fișierul `.bashrc` pentru editare:**
    ```bash
    vi ~/.bashrc
    ```

2. **Adaugă următoarea linie la sfârșitul fișierului:**
    ```bash
    export caleaCatreJavaFX=~/JavaFxSDK24.01/javafx-sdk-21.0.7
    ```

3. **Salvează modificările și ieși din editor (`vi`):**
    - Apasă `Esc`
    - Tastează `:wq` și apasă `Enter`

4. **Reîncarcă fișierul `.bashrc` pentru ca modificările să devină active:**
    ```bash
    source ~/.bashrc
    ```

5. **Verifică dacă variabila a fost setată corect:**
    ```bash
    echo $caleaCatreJavaFX
    ```

6. **Folosește variabila în Eclipse, în câmpul VM arguments:**
    ```bash
    --module-path $caleaCatreJavaFX/lib --add-modules javafx.controls,javafx.fxml
    ```

Acum poți lansa aplicații JavaFX fără a rescrie manual calea completă.
