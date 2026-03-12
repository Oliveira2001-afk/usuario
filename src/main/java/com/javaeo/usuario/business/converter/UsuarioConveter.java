package com.javaeo.usuario.business.converter;

import com.javaeo.usuario.business.dto.EnderecoDTO;
import com.javaeo.usuario.business.dto.TelefoneDTO;
import com.javaeo.usuario.business.dto.UsuarioDTO;
import com.javaeo.usuario.infrastructure.entity.Endereco;
import com.javaeo.usuario.infrastructure.entity.Telefone;
import com.javaeo.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConveter {

	public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
		return Usuario.builder()
				.nome(usuarioDTO.getNome())
				.email(usuarioDTO.getEmail())
				.senha(usuarioDTO.getSenha())
				.enderecos(paraListaEndereco(usuarioDTO.getEnderecos()))
				.telefones(paraListaTelefones(usuarioDTO.getTelefones()))
				.build();



	}

	public List<Endereco> paraListaEndereco(List<EnderecoDTO> enderecoDTOS){
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
     }

	 public Endereco paraEndereco(EnderecoDTO enderecoDTO){
		return Endereco.builder()
				.rua(enderecoDTO.getRua())
				.numero(enderecoDTO.getNumero())
				.cidade(enderecoDTO.getCidade())
				.complemento(enderecoDTO.getComplemento())
				.cep(enderecoDTO.getCep())
				.estado(enderecoDTO.getEstado())
				.build();
	 }

	public List<Telefone> paraListaTelefones (List<TelefoneDTO> telefonesDTO){
		return telefonesDTO.stream().map(this::paraTelefone).toList();
	    }

	 public Telefone paraTelefone (TelefoneDTO telefonesDTO){
		return Telefone.builder()
				.numero(telefonesDTO.getNumero())
				.ddd(telefonesDTO.getDdd())
				.build();
	 }

	public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {
		return UsuarioDTO.builder()
				.nome(usuarioDTO.getNome())
				.email(usuarioDTO.getEmail())
				.senha(usuarioDTO.getSenha())
				.enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos()))
				.telefones(paraListaTelefonesDTO(usuarioDTO.getTelefones()))
				.build();



	}

	public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTO){
		return enderecoDTO.stream().map(this::paraEnderecoDTO).toList();
	}

	public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO){
		return EnderecoDTO.builder()
				.rua(enderecoDTO.getRua())
				.numero(enderecoDTO.getNumero())
				.cidade(enderecoDTO.getCidade())
				.complemento(enderecoDTO.getComplemento())
				.cep(enderecoDTO.getCep())
				.estado(enderecoDTO.getEstado())
				.build();
	}

	public List<TelefoneDTO> paraListaTelefonesDTO(List<Telefone> telefoneDTOS){
		return telefoneDTOS.stream().map(this::paraTelefoneDTO).toList();
	}

	public TelefoneDTO paraTelefoneDTO (Telefone telefonesDTO){
		return TelefoneDTO.builder()
				.numero(telefonesDTO.getNumero())
				.ddd(telefonesDTO.getDdd())
				.build();
	}
}
