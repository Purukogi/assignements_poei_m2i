package fr.patedor.PFR_Equipe.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommandeDto {
	
	private Integer idCommande;
	private String statut;
	private Integer idReservation;
	private List<AssoCommandesPlatsDto> assoCommandesPlatsDto;
	
}
