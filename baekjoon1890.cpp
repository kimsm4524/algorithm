#include<iostream>

using namespace std;



int map[101][101];

long long visited[101][101];



int main(){



	int N;



	cin>>N;



	for(int i=0; i<N; i++){

		for(int j=0; j<N; j++)

			cin>>map[i][j];

	}

	visited[0][0] = 1;

	

	for(int i=0; i<N; i++){

		for(int j=0; j<N; j++){

			if(map[i][j] == 0)

				continue;

			if(i+map[i][j] < N)

				visited[i+map[i][j]][j] += visited[i][j];

			if(j+map[i][j] < N)

				visited[i][j+map[i][j]] += visited[i][j];

		}

	}



	cout<<visited[N-1][N-1]<<endl;



	return 0;

}
