#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<windows.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void gotoxy(int x, int y)                                                
{                                                                        
	COORD pos = { x - 1, y - 1 };                                        
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);      
}                                                                        

int main()
{
	int y,x,zx,y1,x1; //변수선언
	y=10;       
	x=40;       

	while(1)    
	{
		y1=y;   //움직이기 전 위치 보관하기
		x1=x;   //움직이기 전 위치 보관하기
		zx=_getch(); 
		if(zx==119)y=y-1;
		if(zx==115)y=y+1;
		if(zx==97)x=x-1;
		if(zx==100)x=x+1;
		if(zx==27)break; 
		gotoxy(x,y);                                                       
		printf("@");    

		gotoxy(x1,y1);     //전 위치 화면 지우기
		printf(" ");       //전 위치 화면 지우기
	}
	system("pause");
	return 0;
}
