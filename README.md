# Projet_POO_IHM
projet de POO 2020

Projet de licence en javaFX où le but était d'ajouter une interface graphique à un jeu texte. 

---

## Utilisation

Pour exécuter le jeu : se placer au niveau du dossier source et exécuter
`javac shadowLair/ShadowLairApp1ication.java`

Ensuite, exécuter : `java shadowLair.ShadowLairApp1ication`

Nécéssite java 1.8 avec javaFX inclus (ex : https://www.azul.com/downloads/?version=java-8-lts&package=jdk-fx#zulu).

## Aide de jeu

![aide_jeu](./The%20Shadow%20Lair%20HELP%20page.jpg)

## Mode texte

Il est vivement recommandé d'utiliser un terminal qui supporte les "ANSI escape code"
notamment le terminal windows cmd.exe et powershell ne supportent pas ce format.

Pour lancer le jeu
cd ./out
java Main [difficulté]

(difficulté est un entier entre 0 et 2)

Une fois dans le jeu, vous aurez accès à une variété de commande : 
Une commande prends ou non un certain nombre d'arguments représentés entre crochets []
le raccourci pour effectuer une commande est entre parenthèses ().
Si l'argument optionnel est accolé à un symbole '?'

     Drop : (d) Drop [Objet]
          : lâche un objet au sol depuis votre inventaire 

     Use  : (u) Use  [objet] [objet?]
          : Utiliser un item (possiblement sur un autre ou sur une sortie)
          : exemple : USE Potion, USE arrow Bow, USE redKey Laboratory


     Go   : (g) Go   [Lieux]
          : Se rendre à un endroit
          : par exemple Go Laboratory

     Help : (h) Help [Command]
          : affiche l'aide, ou l'aide d'une commande


     Look : (l) Look [Entity]
          : regarde quelque chose et donne plus de détails
          : par exemple Look Chest

     Quit : (q) Quit
          : quitte le jeu

     Sell : (s) Sell [Npc] [Item]
          : vends un objet à un personnage

     Buy  : (b) Buy  [Npc] [Item]
          : achète un objet à un personnage

     Take : (t) Take [Container?] [Item]
          : prends un objet au sol, ou dans un conteneur
          : par exemple : TAKE Chest Sword

     Talk : (tal) Talk [Npc]
          : parler à un personnage
          : par exemple Talk old_men

     Equip : (eq) Equip [Item]
           : vous equipes de l'objet demandé

     Unequip : (un) Unequip
             : vous déséquipe de l'objet demandé

     Attack  : (a) Attack [Npc]
             : Attaque un personnage

     Inventory : (i) Inventory
               : affiche votre inventaire


Les différents objets, lieux, personnages etc ... du jeu sont affichés avec leur nom raccourci (shortName) entre parenthèses dans le terminal.
Le shortName ou le nom complet de l'objet permettent d'interagir avec les entités dans le jeu.


Votre inventaire est limité : vous ne pouvez pas prendre les objets trop lourds. Pour vous débarrasser des objets encombrants utilisez 'DROP', vous pouvez voir votre inventaire avec la commande 'inventory'

Lorsque vous entrez dans une salle avec un personnage agressif (par exemple un orc), il vous attaquera à vue. Préparez vous avec votre meilleure arme avant de changer de salle.

Lorsqu'un personnage meurt, ses effets tombent à terre. Vous pouvez les ramasser ensuite.

Si vous mourrez alors le jeu s'arrête. 

Pour gagner il vous faudra récupérer un artéfact au mains d'un ennemi puissant.