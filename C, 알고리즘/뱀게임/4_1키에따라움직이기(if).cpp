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
	int y,x,zx; //��������
	y=10;       //y�� ��ġ 10����
	x=40;       //x�� ��ġ 40����  

	while(1)    //��� �ݺ�
	{
		zx=_getch(); //ȭ�鿡�� �Է¹޴� Ű�� zx�� �ֱ�

		if(zx==119)y=y-1;//��
		if(zx==115)y=y+1;//�Ʒ�
		if(zx==97)x=x-1;//����
		if(zx==100)x=x+1;//������
		if(zx==27)break; //ESC     �ݺ��� ����������
		gotoxy(x,y);                                                       
		printf("�޷�");    ///////////////////////////////////
	}
	system("pause");
	return 0;
}
