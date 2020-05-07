import pygame
import sys
import random

CYAN=(0,255,255)
GRAY=(96,96,96)

MAZE_W=11
MAZE_H=9
maze=[]
#
for y in range(MAZE_H):
    maze.append([0]*MAZE_W)

def make_maze():
    #
    XP=[0,1,0,-1]
    YP=[-1,0,1,0]

#
for x in range(MAZE_W):
    maze[0][x]=1