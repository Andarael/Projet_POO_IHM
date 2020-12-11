
Aide de jeu

Attaquer un monstre
(A) Attack <Entité>
Attaque le personnage spécifié avec l’arme actuellement équipée si le personnage se trouve dans la pièce. Le combat ne se termine que lorsque le joueur ou l’adversaire meurt, chacun s’attaquant successivement.
Exemple : Attack Orc

Lâcher un objet
(D) Drop <objet>
Lâche l’objet spécifié de votre inventaire par terre (il se trouvera ainsi sur le sol de la pièce où vous vous situez) si le dit objet se trouve dans votre inventaire.
Exemple : Drop Sword

Aller dans une pièce
(G) Go <endroit>
Vous déplace dans l’endroit spécifié si il y a un accès à cet endroit depuis là où vous êtes et qu’il n’est pas verrouillé.
Exemple : Go Laboratory

Obtenir de l’aide sur les commandes
Help
(H) Help <Commande?>
Vous donne des indications quant à l’utilisation des commandes, et qui sont plus spécifiques si vous indiquez précisément sur quelle commande vous voulez des renseignements.
Exemple : Help Go

Afficher l’inventaire
Inventory
Affiche le contenu de votre inventaire, y compris vos PV, nombre d’items, le poids total, et les pièces d’or.
Exemple : Inventory

Regarder quelque chose
(L) Look <chose?>
Regarde l’entité spécifiée ou la pièce s’il n’y a pas d’arguments. Regarder une entité donne plus de détails sur celle-ci, comme la description, ou le contenu de son inventaire.
Exemple : Look orc

Quitter le jeu
(Q) Quit
Vous fait quitter le jeu.

Prendre un objet
(T) Take <Objet>
Vous permet de prendre l’objet objet spécifié s’il est au sol du lieu actuel et que votre inventaire n’est pas plein.
Take <conteneur> <objet>
Vous permet de prendre un objet dans le conteneur spécifié, si le conteneur est bien dans la pièce, et que l'objet est bien dans le conteneur, et que votre inventaire n’est pas plein.
Exemple : Take Chest Sword

Acheter un objet
(B) Buy <Personnage> <Objet>
Vous permet d’acheter l’objet spécifié à un personnage, si le personnage se trouve bien dans la pièce et qu’il possède bien dans son inventaire l’objet spécifié et que votre inventaire a assez de place pour pouvoir accueillir le dit objet, et enfin que vous avez assez d’or pour pouvoir l’acheter.
Exemple : Buy Merchant Sword

Vendre un objet
(S) Sell <Personnage <Objet>
Vous permet de vendre l’objet spécifié au personnage, si le personnage se trouve bien dans la pièce, que vous possédez bien dans votre inventaire l’objet spécifié, que l’inventaire du dit personnage ait assez de place pour pouvoir accueillir le dit objet, et enfin que le dit personnage possède assez d’or pour pouvoir vous l’acheter.
Exemple : Sell Merchant Sword

Utiliser des objets
(U) Use <objet> <?objet2>
Vous permet d’utiliser un objet, si le dit objet est bien dans votre inventaire, et qu’il est utilisable.
Vous permet également d’utiliser l’objet1 sur l’objet2, si ces deux objets sont bien dans votre inventaire, que l’objet1 et bien utilisable, et qu’il peut être utilisable sur l’objet2.
Exemples : Use Chicken
   Use Arrow Bow
   Use keyR Laboratory

Équiper une arme
(EQ) Equip <Arme>
Vous équipe de l’arme spécifiée si celle-ci se trouve dans votre inventaire. Elle sera utilisée pour les combats. Si une autre arme est équipée, elle sera remise dans votre inventaire. Si pour des raisons de limite de poids l’arme actuelle ne peut être déséquipée, rien ne se passe. L’objet équipé ne rentre pas compte dans le calcul de la limite de poids de l’inventaire.
Exemple : Equip Sword

Déséquiper une arme
(UN) Unequip
Vous déséquipez l’arme équipée si vous en avez une. Si pour des raisons de limite de poids l’objet actuel ne peut pas être déséquipé alors rien ne se passe.
Exemple : Unequip

Parler à un personnage
(TAL) Talk <personnage>
Vous fait parler au personnage spécifié, s'il se trouve dans la pièce et qu’il est amical. S’il a des objets à vendre il vous les présentera.
Exemple : Talk Merchant
