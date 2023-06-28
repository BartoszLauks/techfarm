# Projekt na zaliczenie
### Programowanie aplikacji biznesowych

### Pierwsza instalacja

```bash
# 1
make db_start

# 2
make install

# 3
make run

# wyłączenie apki
make db_stop
```

### Ponowne włączenie apki

```bash
# 1
make db_start

# 2
make run
```

### Endpointy do aplikacji zawierają sie w pliku

```bash
techfarm.postman_collection.json
```

### Backup bazy danych z danymi w pliku
#### Bazę danych moża dodać bezposiredio do konternera lub użyć PHPMyAdmin

```bash
app_db_techfarm.sql
```
