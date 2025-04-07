# Etapa 1: Build Angular
FROM node:20-alpine AS builder

# Crear directorio de trabajo
WORKDIR /app

# Copiar package.json y package-lock.json si está
COPY package*.json ./

# Instalar dependencias
RUN npm install

# Copiar el resto del proyecto
COPY . .

# Compilar Angular (por defecto crea dist/my-app)
RUN npm run build --configuration=production

# Etapa 2: Servidor web (nginx)
FROM nginx:alpine

# Copiar el build al nginx
COPY --from=builder /app/dist/my-app/browser /usr/share/nginx/html


# Redirección para Angular routing (opcional pero recomendado)
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Exponer el puerto
EXPOSE 80

# Arrancar nginx
