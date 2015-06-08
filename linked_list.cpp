#include<iostream>

using namespace std;

struct node {
 
 int data;
 node * next;

};

void insert ( node ** head , int data ) {
  
       if ( *head == NULL ) {

	       *head = new node ;
	       (*head) -> data = data ;
	       (*head) -> next = NULL ;

	     }
	else {

              node * new_node = new node ;
	      new_node -> data = data;
	      new_node -> next = *head;
	      *head = new_node;
	}


	
}

node * search ( node * head, int data ) {

 
          while ( head != NULL ) {

                  if ( head -> data == data ) 
			  return head;

                head = head -> next;

	  }

	  return NULL;


}

node * Delete ( node ** head, int item ) {

    if ( search ( *head, item ) == NULL ) 
	    return NULL;

     if ( (*head) -> data == item ) {

	         node * t =  *head;
                 *head = (*head) -> next ;	     
  	         return t;
	     
     }
    
    node * temp = *head;

    while ( temp -> next  != NULL ) {

        if ( temp -> next -> data == item ) {

		break;

	}

          temp = temp -> next ;

    }

 node * t = temp -> next;
   
 temp -> next = temp -> next -> next;
 return t  ;
  
   

}

void print ( node * head ) {
 
 while ( head != NULL  ) {

   cout << head -> data << " ";
   head = head -> next ;

 }

 cout << endl;


}

int main() {

node * head = NULL;
insert ( &head , 5 );
insert ( &head, 8 );
insert ( &head, 3 ) ;
print ( head ) ;

if ( search ( head, 5 ) != NULL  ) {
  
    cout << "5 found \n";

}

else {

 cout << "5 not found \n";

}

Delete ( &head, 5 );
print ( head );
Delete ( &head, 3 );
print (  head   );

return 0;
}

