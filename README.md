# pinApp-challenge

1) Hay que tener instalado gcli en la computer
2) la instancia debe tener permisos de cuenta (IAM CONSOLE)
3) recordar que la app necesita tener creada una archive json Key para poder levantar local apuntando  Db en prod. Panel Iam and Administration en google cloud
Dentro de carpeta target gcloud app deploy (nombre del jar) Example: gcloud app deploy clientes-0.0.1-SNAPSHOT.jar


gcloud projects add-iam-policy-binding (idproject) --member="user:(miemail)" --role="roles/appengine.deployer"
