//
// Created by huc3 on 6/10/2021.
//

#ifndef TOWERDEFENSE_COORDINATESFACTORY_H
#define TOWERDEFENSE_COORDINATESFACTORY_H

#include "Coordinate.h"
#include <unordered_set>
using namespace std;
struct myHash
{
    size_t  operator()(Coordinate c) const
    {
        int x = c.getX();
        int y = c.gety();
        int tmp = ( y +  ((x+1)/2));
        return static_cast<size_t>(x +  ( tmp * tmp));
    }
};
class CoordinatesFactory{
private:
    unordered_set<Coordinate, myHash> coordinatesSet;
    CoordinatesFactory(){};
public:
    //static Coordinate getCoordinates(int x, int y){ return ;}

};

#endif //TOWERDEFENSE_COORDINATESFACTORY_H
