//
// Created by huc3 on 6/10/2021.
//

#ifndef TOWERDEFENSE_COORDINATE_H
#define TOWERDEFENSE_COORDINATE_H
class Coordinate{
    int x;
    int y;
public:
    Coordinate(int x, int y){
        this->x=x;
        this->y=y;
    }
    bool isEqual(Coordinate* coordinate){ return true;}
    bool isNeighbor(Coordinate* coordinate){ return true;}
    int  getX(){ return x;};
    int  gety(){ return y;};
};

#endif //TOWERDEFENSE_COORDINATE_H
