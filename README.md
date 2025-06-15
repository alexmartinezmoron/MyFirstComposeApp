markdown
# MyFirstComposeApp

Aplicación de ejemplo usando Jetpack Compose en Android.

## Características

- Uso de componentes personalizados (`MySwitch2`, `MySlider`, etc.)
- Manejo de estado con `rememberSaveable`
- Ejemplo de integración de iconos y sliders

## Requisitos

- Android Studio Meerkat Feature Drop | 2024.3.2 Patch 1
- Kotlin
- Gradle

## Instalación

1. Clona el repositorio:
2. 2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle.
4. Ejecuta la app en un emulador o dispositivo físico.

## Estructura del proyecto

- `components/`: Componentes personalizados de Compose.
- `MainActivity.kt`: Entrada principal de la aplicación.

## Uso

Ejemplo de uso de un componente:

```kotlin
MySwitch2(icon = { MyIcon() })
