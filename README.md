## setup java
- ``asdf plugin-add java``
- ``asdf install java openjdk-17``
- ``asdf global java openjdk-17``
- ``echo '\n . ~/.asdf/plugins/java/set-java-home.zsh \n' >> ~/.zshrc``

## start project
- ``./gradlew bootRun``

## setup mysql
- ``brew install mysql``
- ``mysql -h localhost -P 3306 --protocol=tcp -u root -p``

## setup DBeaver
- make sure to connect to sql server using mysql cli first
- now connect using DBeaver

## setup thunderclient/postman
- import [StudentsInfoAPICollection](StudentsInfoAPICollection.json)
- start querying