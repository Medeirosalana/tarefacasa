package controller;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
    
    private final UsuarioDAO dao;
    
    public UsuarioController() {
        dao = new UsuarioDAO();
    }
    
    public boolean cadastrar(Usuario usuario) {
        if (dao.findByLogin(usuario.getLogin()) == null) {
            if (dao.create(usuario)) {
                return true;
            }
        }
        return false;
    }
    
    
    public boolean exclir(String login){
        Usuario usuario = dao.findByLogin(login);
    if(usuario != null ){
       dao.delete(usuario);
    return true;
    }
    return false;
    }
    
    public boolean login(String login, String senha) {
        Usuario usuario = dao.findByLogin(login);
        if (usuario != null && usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
            return true;
        }
        return false;
    }
    
      public boolean editar ( String login,String nome){
        Usuario uv = dao.findByLogin(login);
        if(uv != null && uv.getLogin().equals(login)){
          uv.setNome(nome);          
          uv.setId(uv.getId());
          dao.update(uv);
        return true;
           }
         return false;
        }


    
    
}
