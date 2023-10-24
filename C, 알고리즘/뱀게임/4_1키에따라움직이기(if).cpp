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
	int y,x,zx; //변수선언
	y=10;       //y축 위치 10으로
	x=40;       //x축 위치 40으로  

	while(1)    //계속 반복
	{
		zx=_getch(); //화면에서 입력받는 키값 zx에 넣기

		if(zx==119)y=y-1;//위
		if(zx==115)y=y+1;//아래
		if(zx==97)x=x-1;//왼쪽
		if(zx==100)x=x+1;//오른쪽
		if(zx==27)break; //ESC     반복문 빠져나오기
		gotoxy(x,y);                                                       
		printf("메롱");    ///////////////////////////////////
	}
	system("pause");
	return 0;
}
