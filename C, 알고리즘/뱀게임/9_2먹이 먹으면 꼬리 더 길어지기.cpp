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


void textcolor(int color_number)                    
{
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color_number);
}

int main()
{
	srand(time(NULL));
	int i,ex,ey,y,x,zx=0,y1,x1,E[30][100]={0},jumsu=0; 
	int S[20][3]={0},L=5; //���� ��ü��ġ ����� S[][]�� L�� ����
	y=10;       
	x=40;       

	//////////////////////////////////////////////// ���� ǥ�ñ���
	textcolor(10);
	gotoxy(1,2);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); 
	gotoxy(1,24);
	printf("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	textcolor(14);
	gotoxy(45,1);
	printf("����� ����:%3d��",jumsu);
	///////////////////////////////////////////////
	
	for (i = 1; i <= 10; i++)
	{
		ey = rand() % 21 + 3;
		ex = rand() % 76 + 4;
		E[ey][ex]=1;         
		textcolor(2);        
		gotoxy(ex, ey);      
		printf("$");         
	}
	

	while(1)    
	{
		Sleep(100);
		y1=y;   
		x1=x;  
		if(_kbhit()){zx=_getch();}
		if(zx==119)y=y-1;
		if(zx==115)y=y+1;
		if(zx==97)x=x-1;
		if(zx==100)x=x+1;
		if(zx==27)break;
		
		if(x==80)x=2;               
		if(x==1)x=79;              
		if(y==24)y=3;               
		if(y==2)y=23;              

        		
		for(i=L-1;i>=0;i--)
		{
			S[i+1][1]=S[i][1];
			S[i+1][2]=S[i][2];
		}

		gotoxy(S[L][2],S[L][1]); //�̵��ϱ�����ǥ������
		printf(" ");             //
		
		S[0][1]=y;   //���� ��ġ�� ��ǥ�� ����
		S[0][2]=x;
		
		gotoxy(S[0][2],S[0][1]); //if���� ���� x,y�� *�� ����
		textcolor(12);
		printf("@");		
		

		if(E[y][x]==1)
		{	
			L=L+1;
			jumsu+=10;
			textcolor(14);
			gotoxy(45,1);
			printf("����� ����:%3d��",jumsu);
			E[y][x]=0;     
		}
	}
	system("pause");
	return 0;
}
