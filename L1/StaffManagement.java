#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct StaffList_Node {
	int id;
	char name[20];
	int pay;
}StaffList_Node;

typedef struct StaffList {
	int MAX_Staff;
	int Current_Staff;
	StaffList_Node* P_Node;


}StaffList;

StaffList* createStaffList(int MAX_Staff);
void addStaff(StaffList* P_List, int position, StaffList_Node newstaff);
StaffList_Node* getStaff(StaffList* P_List, int position);
void showall(StaffList* P_List, StaffList_Node* P_Value);
void payup_all(StaffList* P_List, StaffList_Node* P_Value);
void payup_one(StaffList* P_List, StaffList_Node* P_Value);

int main()
{
	StaffList* P_List = NULL;
	StaffList_Node* P_Value = NULL;

	int select;

	P_List = createStaffList(500); // 최대인원 500의 리스트 생성

	while (1)
	{
		printf("\n\n\n================================== \n");
		printf("수행할 작업을 선택하세요 : \n\n");
		printf("1. 사원 추가 \n\n");
		printf("2. 모든 사원 보기\n\n");
		printf("3. 모든 사원 급료인상\n\n");
		printf("4. 선택한 사원 급료인상\n");
		printf("================================== \n");
		scanf_s("%d", &select);
		switch (select)
		{
		case 1://사원추가 
				 if(P_List != NULL) 
			{
				StaffList_Node temporary;
				printf("\n\n사번을 입력해주시오: \n");
				scanf_s("%d", &temporary.id);
				
				//사번의 범위제한
				if (temporary.id < 11111 || temporary.id >99999)
				{
					fprintf(stderr, "오류: 사번은 11111부터 99999사이의 수로 입력되어야 합니다");
					exit(1);
				}
		

				//사번의 중복검사
				for (int i = 0; i < P_List->Current_Staff; i++)
				{
					P_Value = getStaff(P_List, i);
					if (temporary.id == P_Value->id )
					{
						fprintf(stderr, "오류: 중복되는 사번이 존재합니다");
						exit(1);
					}
				}

				printf("이름을 입력해주시오: \n");
				scanf_s("%s", temporary.name, 20);
				printf("급여을 입력해주시오: \n");
				scanf_s("%d", &temporary.pay);

				addStaff(P_List, P_List->Current_Staff, temporary);
			}
		continue;

		case 2: //사원전체 목록 출력
			showall(P_List, P_Value);
		continue;

		case 3://사원전체 percent만큼 월급 인상
			payup_all(P_List, P_Value);
		continue;

		case 4:
			payup_one(P_List, P_Value);
		continue;
		}
	}
	return 0;
}




StaffList* createStaffList(int MAX_Staff)
{
	StaffList* pReturn = NULL;
	

	if (MAX_Staff > 0)
	{
		pReturn = (StaffList*)malloc(sizeof(StaffList));

		if (pReturn != NULL)
		{
			pReturn->MAX_Staff = MAX_Staff;
			pReturn->Current_Staff = 0;
			pReturn->P_Node = NULL;
		}
		else 
		{
			printf("오류, 메모리할당 createStaffList()\n");
			return NULL;
		}
	}
	else 
	{
		printf("오류, 최대 사원수는 0이상이어야 합니다\n");
		return NULL;
	}

	pReturn->P_Node = (StaffList_Node*)malloc(sizeof(StaffList_Node) * MAX_Staff); //StaffList_Node 를 MAX_Staff 개수만큼 만든다
	if (pReturn->P_Node == NULL) 
	{
		printf("오류, 2번째 메모리할당 createArrayList()\n");
		free(pReturn); return NULL;
	}
	memset(pReturn->P_Node, 0, sizeof(StaffList_Node) * MAX_Staff); //StaffList_Node 전체의 데이터값을 0으로 초기화한다.

	return pReturn;
}

void addStaff(StaffList* P_List,int position, StaffList_Node newstaff)
{
	if (P_List != NULL) 
	{
		P_List->P_Node[position] = newstaff; //지정한 위치에 삽입할 구조체 추가
	}
	P_List->Current_Staff++;

	printf("\n\n");
	printf("입력완료...");
	printf("\n\n");
	return;
}

StaffList_Node* getStaff(StaffList* P_List, int position)
{
	StaffList_Node* P_Return = NULL;
	if (P_List != NULL)
	{
		P_Return = &(P_List->P_Node[position]);
	}
	return P_Return;
}

void showall(StaffList* P_List, StaffList_Node* P_Value) 
{
	if (P_List != NULL)
	{
		printf("\n\n<<<<<<<<사원 목록을 출력합니다.>>>>>>>>>>\n\n");
		for (int i = 0; i < P_List->Current_Staff; i++)
		{
			P_Value = getStaff(P_List, i);
			printf("-------------------------------------------------------\n");
			printf("[사번]:%d [이름]:%s [급여]:%d \n", P_Value->id, P_Value->name, P_Value->pay);
			printf("-------------------------------------------------------\n");
		}
		printf("\n\n");
		printf("출력완료...");
		printf("\n\n");
	}
}

void payup_all(StaffList* P_List, StaffList_Node* P_Value)
{
	if (P_List != NULL)
	{
		int percent;
		printf("급여를 인상할 퍼센테이지를 입력하시오: ex)80%일경우 '80'입력\n\n");

		scanf_s("%d", &percent);



		for (int i = 0; i < P_List->Current_Staff; i++)
		{
			P_Value = getStaff(P_List, i);
			P_Value->pay = P_Value->pay * ((float)percent / 100) + P_Value->pay;
		}
	}
	printf("\n\n");
	printf("전체인상이 완료되었습니다...");
	printf("\n\n");
}


void payup_one(StaffList* P_List, StaffList_Node* P_Value)
{
	if (P_List != NULL) //사원하나 percent만큼 월급 인상
	{
		int percent;
		int id;

		printf("\n\n급여를 인상할 사원의 사번을 입력하시오: ex)11111~99999\n");

		scanf_s("%d", &id);

		printf("급여를 인상할 퍼센테이지를 입력하시오: ex)80%일경우 '80'입력\n");

		scanf_s("%d", &percent);

		for (int i = 0; i < P_List->Current_Staff; i++)
		{
			P_Value = getStaff(P_List, i);
			if (P_Value->id == id) //사번이 일치할경우
			{
				P_Value->pay = P_Value->pay * ((float)percent / 100) + P_Value->pay;
			}
		}
	}

	printf("\n\n");
	printf("선택인상이 완료되었습니다...");
	printf("\n\n");
}