# Participant
Julien Lalloyer (J)
Matheo Sinquin (M)
Christopher Pottier (C)

# Livrable 1

## Fonctionnalités implémentées

- [X] Afficher la liste détaillée des modèles
- [X] Il est possible de choisir le modèle à visualiser dans la liste
- [X] Le modèle est chargé et visualisé
- [X] Message d'erreur en cas d'erreur de format dans le fichier
- [X] La visualisation est correcte
- [X] On visualise simultanément trois vues du modèle (de face, de haut, de côté)
- [X] Rotation
- [X] Translation ( déplacement dans l'espace )
- [X] Homotétie ( Agrandire reduire )

## Autres éléments demandés

- [X] Tests pour les classes de calcul mathématique
- [X] Captures d'écran pour le rendu
- [X] Vidéo de présentation du rendu
- [/] Respect du format de rendu (cf Moodle)

## Distribution du travail (qui a fait quoi)

### J

- [X] FXML
- [X] File Explorer
- [X] Rotation
- [X] Tests pour la classe de calcul mathématique de multiplication de matrice
- [X] On visualise simultanément trois vues du modèle (de face, de haut, de côté)

### M

- [X] Structure de Graph (Sommets et faces) avec leurs tests
- [X] UpdateGraph (qui permet de mettre à jour le graph par rapport à la matrice)
- [X] Lecteur de Fichier .ply
- [X] Matrice
- [X] Translation (gauche, droite, haut, bas)
- [X] Information du fichier (auteur, NbFace, Commentaires)

### C

- [X] Création du jar exécutable
- [X] Dessiner sur le Canvas
- [X] Homotétie

## Difficultés rencontrées
Problème de classNotFoundException avant le rendu
Le tri n'est pas assez obtimisé
Nous n'avons pas encore trouvé comment afficher uniquement le nom du fichier

# Livrable 2

## Fonctionnalités implémentées


- [X] Affichage faces seulement / segments seulement
- [X] Affichage avancé de la bibliothèque de modèles
- [X] Recherche dans la bibliothèque de modèles
- [X] Éditer les informations sur un modèle (auteur, comment etc...)
- [ ] Modèle centré
- [X] Éclairage
- [ ] Lissage
- [ ] Ombre portée
- [ ] Vue en tranches
- [ ] Controleur horloge
- [ ] Autres, préciser :
- [X] On peut choisir nos propres couleurs

## Autres exigences

- [X] Tests unitaires
- [X] Diagramme de classes UML
- [X] Javadoc
- [X] Captures d'écran
- [X] Vidéo de présentation
- [X] Respect du format de rendu

## Distribution du travail (qui a fait quoi)

### C
- [X] Affichage face seulement / segments seulement / Point seulement
- [X] Affichage des points
- [X] Choix des couleurs
- [X] Vidéo de présentation

### M
- [X] Reorganisation du MainController
- [X] Editions des infos de modeles
- [X] Refonte de l'homethetie et des translations
- [X] Correction de bugs (lecture de fichier, rotations,
- [X] Javadoc
- [X] Diagramme de classes UML
- [X] Erreur PMD

### J
- [X] Travail sur la vue en tranche non fini par manque de temps
- [X] Affichage avancé de la bibliothèque de modèle
- [X] Éclairage
- [X] Javadoc
- [X] Erreur PMD

###Ensemble
- [X] MVC
- [X] Couleurs

## Difficultés rencontrées

Notre modele n'était pas mvc après le livrable 1 et nous avons eu des difficultées à le faire

Les trois vues ne fonctionnent pas (nous avons décidés de retourné à des vues fixes)

Vue en tranche non fini

## Aide à l'utilisation

Appuiyer sur la touche P pour lancer en cas de bug
Si le modele ne s'affiche pas correctement allez dans source folder -> git -> exemples puis selectionnez le model a afficher

Le bouton reinitialiser (ou w) remet le modele a�son etat de base

La rotation s'effectue aussi avec les touches z(haut), q(gauche), s(bas), d(droite),
a(droite par rapport au plan 2D), e(gauche par rapport au plan 2D)

La translation s'effectue aussi avec les touches t(haut) f(dgauche) g(bas) h(droite)

Pour agrandir ou reduire le model b(agrandir) et n(reduire)



