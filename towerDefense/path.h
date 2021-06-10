#ifndef PATH_H_H
#define PATH_H_H

#include "Coordinates.h"

class Path() {
	Path(*Coordinates coordinates);
	Coordinate source;
	Coordinate destination;
	bool checkValidCoordinates();

}
#endif