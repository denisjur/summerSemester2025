### **Git-Befehle – Schnellreferenz**

#### **Git-Repository einrichten**
Select Directory as **Git Repo**  ->  `$git init`

#### **Status anzeigen**
Status ansehen  ->  `$git status`

#### **Dateien zum Staging hinzufügen**
Hinzufügen  ->  `$git add`
Und wenn ich es nicht mehr hinzufügen will?  ->  `$git rm --cached <filename>`

#### **Änderungen committen**
Commiten. Alles im Verlauf schreiben  ->  `$git commit -m ""`

#### **Unterschiede anzeigen**
See what has been modified  ->  `$git diff`

#### **Dateien löschen und wiederherstellen**
file löschen  ->  `$git rm "<filename>"`
Und wiederherstellen  ->  `$git restore "<filename>"`

#### **Commits überprüfen**
Review all commits made  ->  `$git log`
 ->  `$git log --oneline`

#### **Commit-Nachricht korrigieren**
Commit-Nachricht verbessern, da z. B. Fehler  ->  `$git commit -m "<verbesserte Nachricht>" --amend`

#### **Zu einem vorherigen Commit zurückkehren**
You can always jump back to previous commits  ->  `$git reset <HASHTAG-Nummer-von-dem-Befehl git log --oneline>`

---

### **Mit Branches arbeiten**

#### **Branch erstellen und wechseln**
Branch erstellen  ->  `$git branch <nameDesNeuenBranch>`
Um die Anzahl der branches zu sehen  ->  `$git branch`
Branch wechseln  ->  `$git switch <branchName>`

#### **Branch mit Main zusammenführen**
merge / Vereine den Branch wieder mit dem Main branch  ->  `$git merge -m"" <branchName>`  
// Du musst dich im Main Branch befinden, wenn du `merge` benutzt.