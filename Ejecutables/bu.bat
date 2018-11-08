@echo off
set /p sistema=Ingrese sistema:
 start "" http://localhost:8020/AS2DS%sistema%/login.jsf
