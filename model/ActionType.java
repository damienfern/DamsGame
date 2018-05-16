package model;

/**
 * ENUM des différentes actions possibles
 */
public enum ActionType {
    SIMPLEMOVE,                // Déplacement simple sans prise de pièce du jeu opposé
    MOVECATCH,                 // Déplacement avec prise
    NOMOVE                     // pas de déplacement
    ;
}
