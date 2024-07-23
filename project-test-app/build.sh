# 普通镜像构建，随系统版本构建 amd/arm
docker build -t project-test-app:1.0 -f ./Dockerfile .

# 兼容 amd、arm 构建镜像
# docker buildx build --load --platform liunx/amd64,linux/arm64 -t gumo/project-test-app:1.0 -f ./Dockerfile . --push