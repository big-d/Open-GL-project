#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <GL/glut.h>
#include <limits.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/times.h>
#define PS_GRAVITY -9.8
#define PS_WATERFALL  0
#define PS_FOUNTAIN   1


typedef struct {
    float position[3];			/* current position */
    float previous[3];			/* previous position */
    float velocity[3];			/* velocity (magnitude & direction) */
    float dampening;			/* % of energy lost on collision */
    int alive;				/* is this particle alive? */
} PSparticle;


PSparticle* particles = NULL;

int num_particles = 9999;
int type = PS_WATERFALL;
int points = 1;
int draw_spheres = 1;
int frame_rate = 1;
float frame_time = 0;
float flow = 500;
float slow_down = 1;

float spin_x = 0;
float spin_y = 0;
int point_size = 4;



#ifndef CLK_TCK
#define CLK_TCK 1000
#endif

float
timedelta(void)
{
    static long begin = 0;
    static long finish, difference;

    static struct tms tb;
    finish = times(&tb);
    difference = finish - begin;
    begin = finish;

    return (float)difference/(float)CLK_TCK;
}


    
int
fequal(float a, float b)
{
    float epsilon = 0.1;
    float f = a - b;
    
    if (f < epsilon && f > -epsilon)
	return 1;
    else
	return 0;
}


void
psTimeStep(PSparticle* p, float dt)
{
    if (p->alive == 0)
	return;

    p->velocity[0] += 0;
    p->velocity[1] += PS_GRAVITY*dt; //particles falling in the Y direction, each speed indicates the 3 coordinates
    p->velocity[2] += 0;

    p->previous[0] = p->position[0]; //position of each of the particles in all the 3 directions
    p->previous[1] = p->position[1];
    p->previous[2] = p->position[2];

    p->position[0] += p->velocity[0]*dt;
    p->position[1] += p->velocity[1]*dt; // determining the position by using velocity
    p->position[2] += p->velocity[2]*dt; //dt is the time delta
}


void
psNewParticle(PSparticle* p, float dt)
{
    if (type == PS_WATERFALL) {
	p->velocity[0] = -2*(drand48()-0.0);
	p->velocity[1] = 0;
	p->velocity[2] = 0.5*(drand48()-0.0); //presetting the particle with certain speed in x and z coods. Y cood is handled by gravity (above func)
	p->position[0] = 0; //setting arbitary position
	p->position[1] = 2;
	p->position[2] = 0;
	p->previous[0] = p->position[0];
	p->previous[1] = p->position[1];
	p->previous[2] = p->position[2];
	p->dampening = 0.45*drand48();
	p->alive = 1;
    }

    psTimeStep(p, 2*dt*drand48()); // giving "gravity" by specifying the gravity in Y cood
}

void
reshape(int width, int height)
{
    float black[] = { 0, 0, 0, 0 };

    float red[] = {0.1,0.2,0.3,0};
								//reshape function for the code
    glViewport(0, 0, width, height);
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(60, (float)width/height, 0.1, 1000);
    glMatrixMode(GL_MODELVIEW);
    glLoadIdentity();
    gluLookAt(0, 1, 3, 0, 1, 0, 0, 1, 0);
    glFogfv(GL_FOG_COLOR, red); //specifying the attributes for FOG 
    glFogf(GL_FOG_START, 2.5); // fog characteristic increases linearly from fog start, and ends at fog end.
    glFogf(GL_FOG_END, 4); //specifying the terminal attribute for FOG
    glEnable(GL_FOG); //enabling FOG 
    glFogi(GL_FOG_MODE, GL_LINEAR);
    glPointSize(point_size);
    glEnable(GL_POINT_SMOOTH);
    glEnable(GL_BLEND);
    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    glEnable(GL_COLOR_MATERIAL);
    glEnable(GL_DEPTH_TEST);
    glEnable(GL_LIGHT0);

    timedelta();
}


void
display(void)
{
long long int as;
	static int j1=0; 
   static int i;
    static float c;
    static int j = 0;
    static char s[32];
    static int frames = 0;
static float h=2;
// just inerting delay to see whether it looks better or not
//for(as=0;as<100000000;as++);
// nope , doesn't look good with the delay on

    glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
    glPushMatrix();

    glRotatef(spin_y, 1, 0, 0);
    glRotatef(spin_x, 0, 1, 0);

glBegin(GL_POLYGON);
glColor3f(1.0,0.0,0.0); 
glVertex3f( -0.1, -h, -0.1);       // P1
glVertex3f( -0.1,  h, -0.1);       // P2
glVertex3f(  0.1,  h, -0.1);       // P3
glVertex3f(  0.1, -h, -0.1);       // P4
 
glEnd();


glBegin(GL_POLYGON);
 
glColor3f( 1.0, 0.0, 0.0 ); 
    glVertex3f(  0.1, -h, -0.1 );      // P1 is red
     glVertex3f(  0.1,  h, -0.1 );      // P2 is red
     glVertex3f( -0.1,  h, -0.1 );      // P3 is red
     glVertex3f( -0.1, -h, -0.1 );      // P4 is red
 
glEnd();



// red side - BACK
glBegin(GL_POLYGON);
	glColor3f(   1.0,  0.0, 0.0 );
glVertex3f(  0.1, -h, 0.1 );
glVertex3f(  0.1,  h, 0.1 );
glVertex3f( -0.1,  h, 0.1 );
glVertex3f( -0.1, -h, 0.1 );
glEnd();
 
// red side - RIGHT
glBegin(GL_POLYGON);
glColor3f(  1.0,  0.0,  0.0 );
glVertex3f( 0.1, -h, -0.1 );
glVertex3f( 0.1,  h, -0.1 );
glVertex3f( 0.1,  h,  0.1 );
glVertex3f( 0.1, -h,  0.1 );
glEnd();
 
// red side - LEFT
glBegin(GL_POLYGON);
glColor3f(   1.0,  0.0,  0.0 );
glVertex3f( -0.1, -h,  0.1 );
glVertex3f( -0.1,  h,  0.1 );
glVertex3f( -0.1,  h, -0.1 );
glVertex3f( -0.1, -h, -0.1 );
glEnd();
 
// red side - TOP
glBegin(GL_POLYGON);
glColor3f(   1.0,  0.0, 0.0 );
glVertex3f(  0.1,  h,  0.1 );
glVertex3f(  0.1,  h, -0.1 );
glVertex3f( -0.1,  h, -0.1 );
glVertex3f( -0.1,  h,  0.1 );
glEnd();
 
// Red side - BOTTOM
glBegin(GL_POLYGON);
glColor3f(   1.0,  0.0,  0.0 );
glVertex3f(  0.1, -.1, -0.1 );
glVertex3f(  0.1, -.1,  0.1 );
glVertex3f( -0.1, -.1,  0.1 );
glVertex3f( -0.1, -.1, -0.1 );
glEnd();
 

/*
glBegin(GL_QUADS);
    glColor3ub(0, 128, j1++);
    glVertex3f(-2, 0, -2);
    glVertex3f(-2, 0, 2);
    glVertex3f(2, 0, 2);
    glVertex3f(2, 0, -2);
    glEnd();
*/
//if(j1==255)
//j1=0;
    if (points) {
	glBegin(GL_POINTS);
	
	for (i = 0; i < num_particles; i++) {
	    if (particles[i].alive == 0)
		continue;
	    c = particles[i].position[1]/2.1*255;
	    glColor3ub(100, 128+0.5, 140);
	    glVertex3fv(particles[i].position);
	}
	glEnd();
    } else {
	glBegin(GL_LINES);
	for (i = 0; i < num_particles; i++) {
	    if (particles[i].alive == 0)
		continue;
	    c = particles[i].previous[1]/2.1*255;
	    glColor4ub(100, 128+0.5, 245, 32);
	    glVertex3fv(particles[i].previous);
	    c = particles[i].position[1]/2.1*255;
	    glColor4ub(100, 128+0.5, 140, 196);
	    glVertex3fv(particles[i].position);
	}
	glEnd();
    }
    glPopMatrix();
    glutSwapBuffers();
}

void
idle(void)
{
    static int i, j;
    static int living = 0;		/* index to end of live particles */
    static float dt;
    static float last = 0;

    dt = timedelta();
    frame_time += dt;

#if 1
    /* slow the simulation if we can't keep the frame rate up around
       10 fps */
    if (dt > 0.1) {
	slow_down = 1.0/(100*dt);
    } else if (dt < 0.1) {
	slow_down = 1;
    }
#endif

    dt *= slow_down;

    /* resurrect a few particles */
    for (i = 0; i < flow*dt; i++) {
	psNewParticle(&particles[living], dt);
	living++;
	if (living >= num_particles)
	    living = 0;
    }

    for (i = 0; i < num_particles; i++) {
	psTimeStep(&particles[i], dt);

	/* dead particle? */
	if (particles[i].position[1] < 0.1 && 
	    fequal(particles[i].velocity[1], 0)) {
	    particles[i].alive = 0;
	}
    }

    glutPostRedisplay();
}

void
visible(int state)
{
    if (state == GLUT_VISIBLE)
	glutIdleFunc(idle);
    else
	glutIdleFunc(NULL);
}

void
bail(int code)
{

	// we could have use exit(0) directly when Esc key is presses but we are freeing the dynamically allocated
// memory and then exiting with the code.. remember that we call bail(0) in keyboard events ...!
    free(particles);
    exit(code);
}

void
keyboard(unsigned char key, int x, int y)
{
    static int fullscreen = 0;
    static int old_x = 50;
    static int old_y = 50;
    static int old_width = 512;
    static int old_height = 512;
    static int s = 0;

    switch (key) {
    case 27:
        bail(0);
	break;
    case 'P':
	point_size++;
	glPointSize(point_size);
	break;
	
    case 'p':
	point_size--;
	if (point_size < 1)
	    point_size = 1;
	glPointSize(point_size);
	break;
	
    case '+':
	flow += 100;
	if (flow > num_particles)
	    flow = num_particles;
	printf("%g particles/second\n", flow);
	break;

    case '-':
	flow -= 100;
	if (flow < 0)
	    flow = 0;
	printf("%g particles/second\n", flow);
	break;


    }
}

void
menu(int item)
{
    keyboard((unsigned char)item, 0, 0);
}

int old_x, old_y;

void
mouse(int button, int state, int x, int y)
{
    old_x = x;
    old_y = y;

    glutPostRedisplay();
}

void
motion(int x, int y)
{
    spin_x = x - old_x;
    spin_y = y - old_y;

    glutPostRedisplay();
}

int
main(int argc, char** argv)
{
    glutInitDisplayMode(GLUT_RGB|GLUT_DEPTH|GLUT_DOUBLE);
    glutInitWindowPosition(0, 0);
    glutInitWindowSize(640, 480);
    glutInit(&argc, argv);

    glutCreateWindow("Marbles falling from a box");
    glutDisplayFunc(display);
    glutReshapeFunc(reshape); 
    glutMotionFunc(motion);
    glutMouseFunc(mouse);
    glutKeyboardFunc(keyboard);
    glutCreateMenu(menu);
   // glutAddMenuEntry("Particle", 0);
    //glutAddMenuEntry("", 0);
    glutAddMenuEntry(" Less Marbles or -", '-');
    glutAddMenuEntry(" More flow or +", '+');
    glutAddMenuEntry(" Smaller points or p", 'p');
    glutAddMenuEntry(" Larger points or P", 'P');
  
    glutAddMenuEntry("[Esc] Quit", 27);
    glutAttachMenu(GLUT_RIGHT_BUTTON);
// dynamically allocating memory for the number of particles initially 
   particles = (PSparticle*)malloc(sizeof(PSparticle) * num_particles);

    glutVisibilityFunc(visible);
    glutMainLoop();
    return 0;
}
