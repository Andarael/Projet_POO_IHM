
Aide de jeu


Une fois le jeu lancé, il vous sera proposé d'avancer dans une salle (go n).
Ici vous êtes confronté à un ennemi, il vous faut entrer un entier afin d'avancer vers lui pour le combattre.
Suite à quoi vous découvrirez une nouvelle salle, vous pouvez faire votre choix suivant les possibilités affichées
La commande go prend une direction {N,E,S,W} en argument, elle est affichée à côté du numéro de la salle lorsque vous tapez look.

Hors combat : help pour afficher les commandes possibles
		
		- go <direction>      : permet de se deplacer dans une salle adjacente
		- help                : affiche la liste des commandes
		- look                : donne une description de la piece
		- look <objet>        : donne un descriptif de l'objet
		- take <objet>        : recupere l'objet et le place dans l'inventaire
		- quit                : quitte la partie
		- use <objet>         : utilise l'objet
		- use <objet> <objet> : utilise les deux objets si une combinaison est possible
		- inv                 : affiche l'inventaire du joueur



Marchand :
Lorsqu’un marchand vous propose des objets, il faut rentrer le nombre entier correspondant à l’objet proposé précédemment.
 Par exemple si vous voyez ceci :
Vous pouvez acheter une lance pour 15PO en entrant la valeur 2 sur la ligne de commande.
Si vous ne souhaitez pas acheter d’objet, il suffit d’entrer une valeur négative.




Combat :
Lorsqu’une salle contient un ennemi et que vous rentrez dedans, un combat se lance automatiquement. On peut voir une interface en 2D qui montre la position du joueur (P), celle de l’ennemi (E) et si tous les deux sont sur la même case (B).
Les cases vides sont représentées par un “-” .
Vous pouvez entrer un nombre positif pour vous déplacer vers la droite et un négatif pour aller vers la gauche.
Une fois que le joueur a avancé, il attaque puis l’ennemi fait un déplacement et attaque à son tour.
Après un combat, si vous gagnez vous récupérez l’or que l’ennemi possédait et tous ses objets sont déposés dans la salle.


Portes bloquées :
Lorsque vous voyez qu’une porte est bloquée par un rocher, il faut trouver une pioche et utiliser la commande use dans la salle pour libérer le passage.
Si la porte est verrouillée, il faut faire la même manipulation avec une clé.


Objets :
La nourriture peut être consommée avec la commande use pour regagner un certain nombre de points de vie.
L’arme équipée par le joueur peut être échangée par une autre que vous pourrez trouver pendant votre aventure en utilisant la commande use. L’ancienne arme se trouve désormais dans l’inventaire du joueur.
