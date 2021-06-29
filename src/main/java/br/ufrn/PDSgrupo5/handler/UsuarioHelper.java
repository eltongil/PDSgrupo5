package br.ufrn.PDSgrupo5.handler;

import br.ufrn.PDSgrupo5.model.Usuario;
import br.ufrn.PDSgrupo5.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class UsuarioHelper {
    private Usuario usuarioLogado;

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioHelper(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @ModelAttribute("usuarioLogado")
    public Usuario usuarioLogado(){
        return getUsuarioLogado();
    }

    public Usuario getUsuarioLogado() {
        if(getLoginUsuario() != null) {
            if(usuarioLogado != null && !usuarioLogado.getLogin().equals(getLoginUsuario())) {
                usuarioLogado = null;
            }
            if(usuarioLogado == null) {
                usuarioLogado = usuarioRepository.findByLogin(getLoginUsuario());
            }
        }
        return usuarioLogado;
    }

    public String getLoginUsuario() {
        if(SecurityContextHolder.getContext().getAuthentication() != null)
            return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return null;
    }
}
