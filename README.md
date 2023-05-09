# demoJWT-Token
Das ist ein Beispiel für die Authentifizierung mit den JWT-Tokens. Im Beispiel kann man einen User erstellen und Authentifizieren lassen.
Indem Beispiel werden noch einige Andere gezeigt z.B. das Hashen von Passwörten, das ändern der SecurityFilterChain usw..
Die meisten Sachen habe ich zur Klarheit auskommentiert.

Als erstes muss man den Benutzernamen und Passwort seiner localen Datenbank in der application.yml angeben.

Das Erstellen des Users und dessen Authentifizierung kann man unter der Anwendung Postman machen. 
Einfach der "Post" Methode unter http://localhost:8080/beispiel/register ein Benutzer im folgenden Format anlegen.:
    {
    "vorname": "Tjark",
    "nachname": "Wichmann",
    "email": "tjark.wichmann@stud.th-luebeck.de",
    "passwort": "1234"
}

Die Authentifizierung geschieht unter http://localhost:8080/beispiel/authenticate, wobei nur die E-Mail und das Passwort benötigt werden.

