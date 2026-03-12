package com.javaeo.usuario.business;

import com.javaeo.usuario.business.converter.UsuarioConveter;
import com.javaeo.usuario.business.dto.UsuarioDTO;
import com.javaeo.usuario.infrastructure.entity.Usuario;
import com.javaeo.usuario.infrastructure.exeptions.ConflictException;
import com.javaeo.usuario.infrastructure.exeptions.RescoucerNotFoundException;
import com.javaeo.usuario.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final UsuarioConveter usuarioConveter;
	private final PasswordEncoder passwordEncoder;


    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        emailExiste(usuarioDTO.getEmail());
		usuarioDTO.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
		Usuario usuario = usuarioConveter.paraUsuario(usuarioDTO);
		return usuarioConveter.paraUsuarioDTO(
				usuarioRepository.save(usuario)
 		);
	}

	public void emailExiste(String email){
		try{
			boolean existe = verificaEmailExistente(email);
			if (existe){
				throw new ConflictException("Email já cadastrado" + email);
			}
		}catch (ConflictException e){
			throw new ConflictException("Email já cadastrado" + e.getCause());
		}
	}

	public boolean verificaEmailExistente(String email){
		return usuarioRepository.existsByEmail(email);
	}

	public Usuario buscarUsuarioPorEmail(String email){
		return usuarioRepository.findByEmail(email).orElseThrow(
				() -> new RescoucerNotFoundException("Email não encontrado" + email));
	}
	public void deletaUsuarioPorEmail(String email){
		usuarioRepository.deleteByEmail(email);
	}

}
