#ifndef TOWER_H_H
#define TOWER_H_H

#include "attackTower.h"
#include "defenseTower.h"
#include "mainTower.h"

class Tower() {
	attackTower at();
	defenseTower dt();
	mainTower mt();
}

#endif