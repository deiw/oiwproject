package pl.majorczyk.server.user;

interface UserCreator {
    UserEntity create(UserData userData);
}
