@echo off
set /p Etapa=Etapa:
@echo off
set /p Comentario=Comentario:
E:
cd /FrameworkAsinfo
git add .
git commit -m  "%date%--%time%--%ETAPA%--%comentario%"
git push origin master