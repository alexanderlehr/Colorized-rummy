# Colorized-rummy

Hier möchte ich auf die Frage eingehen, wie ich bei dem Problem vorgegangen bin:

Zu aller erst habe ich den Input-String zu einer Liste von Chars gemacht, bin dort durchgelooped und habe anschließend alle Zeichen zu einer Liste hinzugefügt.
Wenn ein Buchstabe nicht "r", "y", "b" oder "k" war, habe ich den Vorgang abgebrochen.

Da nun ja jedes char einen Platz in einer Gruppe sucht, gehe ich zuerst alle chars durch, um jedem einen Platz zuzuordnen.
In dieser for Schleife gehe ich alle Listen durch um zu prüfen ob er irgendwo rein passt. Wenn er wo rein passt wird er da hinzugefügt, wenn er nirgendwo
reinpasst wird eine neue Gruppe für ihn erstellt, wenn alle anderen Gruppen bereits ihre 3 Plätze für die mindestanzahl gefüllt haben. 
Wenn dann einmal durch alle chars durchgegangen wurde, gehe ich durch die Listen durch und versuche nurnoch aufzufüllen.

Sollte nach diesen ganzen Vorgängen immernoch irgendwelche Chars in keiner Gruppe sein, wird "Error" in die Konsole geschrieben, ansonsten "Success"
