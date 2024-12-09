# GestionPacientes - Backend Java Spring Boot

GestionPacientes es una aplicación desarrollada con **Spring Boot** para la gestión de pacientes, permitiendo realizar operaciones CRUD a través de una API RESTful. Este archivo contiene las instrucciones para correr la aplicación localmente, probar la API con Postman, y opcionalmente desplegarla en **Kubernetes**.

---

## 📑 Tabla de Contenidos
- [Requisitos previos](#requisitos-previos)
- [Correr la aplicación localmente](#correr-la-aplicación-localmente)
- [Realizar pruebas en Postman](#realizar-pruebas-en-postman)
- [Despliegue en Kubernetes (Opcional)](#despliegue-en-kubernetes-opcional)
- [Licencia](#licencia)

---

## 🛠️ Requisitos previos

Antes de comenzar, asegúrate de tener instalados los siguientes requisitos:

- **Java 11** o superior: La aplicación está configurada para ejecutarse con Java 11.
- **Maven**: Para la gestión de dependencias y compilación del proyecto.
- **Docker** (opcional para el despliegue en Kubernetes).
- **Kubernetes** (opcional para el despliegue en un clúster).

---

## 🚀 Correr la aplicación localmente

### 1. Clonar el repositorio

Si aún no tienes el repositorio, clónalo usando Git:

```bash
git clone https://github.com/TU_USUARIO/gestion-pacientes.git
cd gestion-pacientes
```

### 2. Configurar el entorno
Asegúrate de tener configurado el JDK 11 y Maven en tu máquina. Si estás usando un IDE como IntelliJ IDEA o VS Code, el proyecto debería detectarlos automáticamente.

### 3. Ejecutar la aplicación
Para ejecutar la aplicación localmente, abre una terminal y navega al directorio raíz del proyecto. Luego, ejecuta el siguiente comando para compilar y ejecutar el proyecto:

```bash
mvn spring-boot:run
```
Este comando descargará las dependencias necesarias y ejecutará la aplicación en http://localhost:8080.

Nota: Si el puerto 8080 ya está en uso, puedes cambiar el puerto en el archivo application.properties o application.yml de la siguiente manera:
server.port=8081
### 4. Verificar que la aplicación está corriendo
Abre un navegador web y visita http://localhost:8080. Deberías ver el endpoint de bienvenida de la API, o una respuesta JSON si está configurado para hacerlo.

## 🧪 Realizar pruebas en Postman

Para probar la API, puedes usar herramientas como Postman o Insomnia. A continuación se describen algunos endpoints básicos para probar:

Endpoints disponibles
* GET /api/pacientes: Obtiene todos los pacientes registrados.
* GET /api/pacientes/{id}: Obtiene un paciente específico por su ID.
* POST /api/pacientes: Crea un nuevo paciente.
* PUT /api/pacientes/{id}: Actualiza los detalles de un paciente existente.
* DELETE /api/pacientes/{id}: Elimina un paciente por su ID.

### Pasos para realizar pruebas:
Iniciar Postman y crear una nueva colección.
Configurar el entorno para apuntar a http://localhost:8080 (o el puerto que hayas configurado).

Agregar las siguientes solicitudes en la colección:
* GET /api/pacientes: Método GET para listar todos los pacientes.
* POST /api/pacientes: Método POST para crear un nuevo paciente. Ejemplo de body en formato JSON:
```json
{
"nombre": "Juan Perez",
"edad": 45,
"direccion": "Calle Falsa 123"
}
```
* GET /api/pacientes/{id}: Método GET para obtener un paciente específico por ID.
* PUT /api/pacientes/{id}: Método PUT para actualizar un paciente. Ejemplo de body:
```json
{
"nombre": "Juan Pérez Actualizado",
"edad": 46,
"direccion": "Calle Verdadera 456"
}
```

* DELETE /api/pacientes/{id}: Método DELETE para eliminar un paciente por ID.

Enviar las solicitudes y verificar las respuestas.
## ☁️ Despliegue en Kubernetes (Opcional)

Si deseas desplegar la aplicación en un clúster de Kubernetes, sigue estos pasos:

### 1. Crear la imagen Docker de la aplicación
   Primero, necesitas crear una imagen Docker de la aplicación para que pueda ser ejecutada en Kubernetes.

Crear el archivo Dockerfile

En la raíz del proyecto, crea un archivo llamado Dockerfile con el siguiente contenido:
```dockerfile
FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/gestion-pacientes-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
```
### 2. Construir la imagen Docker
   Ejecuta el siguiente comando para construir la imagen Docker:
```dockerfile
docker build -t gestion-pacientes .
```
### 3. Crear los archivos de configuración de Kubernetes
   Crea un archivo llamado deployment.yaml con el siguiente contenido para desplegar la aplicación en Kubernetes:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
name: gestion-pacientes-deployment
spec:
replicas: 1
selector:
matchLabels:
app: gestion-pacientes
template:
metadata:
labels:
app: gestion-pacientes
spec:
containers:
- name: gestion-pacientes
image: gestion-pacientes:latest
ports:
- containerPort: 8080
---
apiVersion: v1
kind: Service
metadata:
name: gestion-pacientes-service
spec:
selector:
app: gestion-pacientes
ports:
- protocol: TCP
port: 8080
targetPort: 8080
type: LoadBalancer
```
### 4. Desplegar la aplicación en Kubernetes
   Aplica los archivos de configuración a tu clúster de Kubernetes:
```yaml
kubectl apply -f deployment.yaml
```
### 5. Acceder a la aplicación
   Si todo está configurado correctamente, Kubernetes asignará una IP externa o un LoadBalancer para que puedas acceder a la aplicación.

## 📝 Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.


### Explicación de los iconos:

- 📑 **Tabla de Contenidos**: Indicador de la sección de contenido.
- 🛠️ **Requisitos previos**: Requisitos para ejecutar el proyecto.
- 🚀 **Correr la aplicación localmente**: Instrucciones para ejecutar la aplicación en tu máquina.
- 🧪 **Realizar pruebas en Postman**: Instrucciones para probar la API.
- ☁️ **Despliegue en Kubernetes**: Instrucciones para desplegar la aplicación en Kubernetes.
- 📝 **Licencia**: Información sobre la licencia del proyecto.




