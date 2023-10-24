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
	int y,x,zx,y1,x1; 
	y=10;       
	x=40;       

	while(1)    
	{
		y1=y;   
		x1=x;  
		zx=_getch(); 
		if(zx==119)y=y-1;
		if(zx==115)y=y+1;
		if(zx==97)x=x-1;
		if(zx==100)x=x+1;
		if(zx==27)break;

		//////////////////////////////
		if(x==80)x=2;               //통과구간
		if(x==1)x=79;               //통과구간
		if(y==24)y=3;               //통과구간
		if(y==2)y=23;               //통과구간
		//////////////////////////////
		
			gotoxy(x,y);                                                       
		printf("@");    
		gotoxy(x1,y1);     
		printf(" ");       
	}
	system("pause");
	return 0;
}
