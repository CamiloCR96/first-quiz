import sqlite3

# Nombre de la base de datos
DB_NAME = "quiz_pets"

def check_tables_exist():
    con = sqlite3.connect(DB_NAME)
    cursor = con.cursor()

    # Lista de nombres de las tablas que se esperan
    expected_tables = ["animals", "people", "people_animals"]

    for table_name in expected_tables:
        cursor.execute(f"SELECT name FROM sqlite_master WHERE type='table' AND name='{table_name}'")
        result = cursor.fetchone()
        if result is None:
            print(f"La tabla {table_name} no se encuentra en la base de datos.")
        else:
            print(f"La tabla {table_name} está presente en la base de datos.")

    con.close()

check_tables_exist()
