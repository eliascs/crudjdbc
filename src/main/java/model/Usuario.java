package model;

public class Usuario {

    String email;
    String senha;
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {

        return
                "\nID: " + id +
                "\nEMAIL: " + email +
                "\nSENHA: " + senha +"\n"
               ;
    }
}