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
	int y,x,zx,y1,x1; //��������
	y=10;       
	x=40;       

	while(1)    
	{
		y1=y;   //�����̱� �� ��ġ �����ϱ�
		x1=x;   //�����̱� �� ��ġ �����ϱ�
		zx=_getch(); 
		if(zx==119)y=y-1;
		if(zx==115)y=y+1;
		if(zx==97)x=x-1;
		if(zx==100)x=x+1;
		if(zx==27)break; 
		gotoxy(x,y);                                                       
		printf("@");    

		gotoxy(x1,y1);     //�� ��ġ ȭ�� �����
		printf(" ");       //�� ��ġ ȭ�� �����
	}
	system("pause");
	return 0;
}
