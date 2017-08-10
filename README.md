# SosafeTest

Desafio de Codigo SoSafe para obtener una imagen desde una URL y mostrar en la aplicación. Se desarrolla y se hacen pruebas en: 

* IDE: Android Studio 3.0 Beta 1 (10/08/2017)
* OS: Mac OS X Sierra 10.12.6
* PC: MacBook Pro Mid 2009

Básicamente se obtiene la imagen con la librería **Glide** y al hacer click en el boton, ejecuta la descarga de la imagen rotada 180 grados. Se sugieren las siguientes condiciones para mitigar posibles errores y tener una buena experiencia de usuario (los cuales está implementados):

* Descarga de imagen de menor tamaño para no provocar Leak de Memoria (OutOfMemoryError)
* Considerar persistencia de datos en cache de aplicación. Glide lo controla con
```
.diskCacheStrategy(DiskStrategy.SOURCE);
```
* Controlar errores de carga de imagen como conexión a Internet, Error 400, 500, 403, etc. En Glide se controla con el callback al momento de capturar la descarga:

```
public void onFailed();
```

* Para la rotación de la imagen se creo una clase para rehacer el bitmap y se realiza una transformación de la matriz en 180 grados y aplicacion un GlideTransformation.

* Al rotar el dispositivo, se debe guardar la instancia de la imagen a través de onSaveInstanceState. Se guarda la imagen al llegar a este ciclo, y luego se obtiene al recrear la vista guardando el Bitmap

* Se utilizan las buenas prácticas de programación Java, patrones de diseño, depuración, diccionarios de Strings, colores, dimensiones, métodos útiles.
