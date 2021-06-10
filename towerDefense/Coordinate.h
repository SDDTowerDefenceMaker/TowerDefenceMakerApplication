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
    bool isNeighbor(Coordinate* coordinate){ return true;}
    int  getX(){ return x;};
    int  gety(){ return y;};
    bool Equals(Coordinate Obj) const  {
        return Obj.y==this->y&&Obj.x==this->x;
    }
    bool operator ==(const Coordinate c){
        return this->Equals(c);
    }

};
bool operator==(const Coordinate& a, const Coordinate& b) {
    return a.Equals(b);
}

#endif //TOWERDEFENSE_COORDINATE_H
