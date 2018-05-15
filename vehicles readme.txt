Vehicles project Assignment 6 for Gladys Monagan's CPSC 1181 OOP
James Young

This program uses polymorphism since VehicleComponent uses an Arraylist of Vehicles which can be used to 
create any vehicles(car, bike, truck).

VehicleComponent also extends Jcomponent and also uses methods such as repaint() in order to animate the vehicles.

The respective vehicle subclasses also call upon the Vehicle constructor in order to initialize their position and color values.

Any operation involving a vehicle call inside VehicleComponent calls upon the subclasses of Vehicles and can move each one
independtly regardless of a vehicle being a car, bike, or truck.