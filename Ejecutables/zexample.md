@echo off
set /p bdd=Base de datos:
set /p ubicacion=Ubicacion:
SET PGPASSWORD=asinfo2680-
c:
cd "C:\Program Files\PostgreSQL\9.4\bin"
pg_restore -h localhost -p 5432 -U postgres -d %bdd% -v "%ubicacion%"
pause
