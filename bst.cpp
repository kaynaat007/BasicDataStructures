#include<iostream>
#include<cstdlib>
#include<ctime>



using namespace std;

struct node {
 
  node * left;
  node * right ;

  int data ;

} ;


void insert ( node ** root , int data  ) {

      if ( (*root) == NULL  ) {

          (*root) = new node;
	  (*root) -> data = data ;
	  (*root) -> left = NULL;
	  (*root)-> right = NULL ;
	  return ;

      }

      if ( data < (*root) -> data ) {

            insert ( &( (*root) -> left ), data ) ;
      }
     else  {

  
            insert (  &( (*root) -> right ), data ) ;

	  }


}


void inorder ( node * root ) {

   if ( root != NULL  ) {

       inorder ( root -> left ) ;
       cout << root -> data << " ";
       inorder ( root -> right ) ;
   }

}



int main() {

 int n;
 cout << "enter number of nodes : \n"   ;
 node * root = NULL;
 cin >> n;
 srand ( time(NULL) ) ;
 while ( n ) {

     int x =  rand() % 500;
     cout << "generated : " << x << endl;
     insert ( &root , x  );
     n--;    
 }

 inorder ( root ) ;


return  0;

}
