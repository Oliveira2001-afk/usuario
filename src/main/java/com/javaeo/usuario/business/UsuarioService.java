package com.javaeo.usuario.business;

import com.javaeo.usuario.business.converter.UsuarioConveter;
import com.javaeo.usuario.business.dto.UsuarioDTO;
import com.javaeo.usuario.infrastructure.entity.Usuario;
import com.javaeo.usuario.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioConveter usuarioConveter;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
		Usuario usuario = usuarioConveter.paraUsuario(usuarioDTO);
		return usuarioConveter.paraUsuarioDTO(
				usuarioRepository.save(usuario)
 		);
	}

}
