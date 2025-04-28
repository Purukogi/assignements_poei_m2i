package fr.patedor.PFR_Equipe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UtilisateurDTO {
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
}
