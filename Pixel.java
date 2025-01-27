// Trame du TP sur les traces de base
// BUT Info - 2024/2025
// Preparateur: P. Even (Universite de Lorraine / IUT de Saint-Die, Dpt Info)
// Complete par X

import java.util.ArrayList;

/** Pixel de la grille.
 */
public class Pixel
{
  /** Abscisse du pixel. */
  protected int x;
  /** Ordonnee du pixel. */
  protected int y;


  /** Cree un pixel a partir de ses coordonnees.
   * @param x abscisse du pixel.
   * @param y ordonnee du pixel.
   */
  public Pixel (int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  /** Fournit l'abscisse du pixel.
   * @return L'abscisse du pixel.
   */
  public int x ()
  {
    return (x);
  }

  /** Fournit l'ordonnee du pixel.
   * @return L'ordonnee du pixel.
   */
  public int y ()
  {
    return (y);
  }

  /** Fournit les pixels du segment joignant le pixel a un autre.
   * @param p Le pixel d'arrivee.
   * @return La sequence de pixels du segment.
   */
  public Pixel[] tracerSegment(Pixel p) {
    ArrayList<Pixel> pixels = new ArrayList<>();
    
    int x1 = this.x;
    int y1 = this.y;
    int x2 = p.x();
    int y2 = p.y();
    
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);
    
    int sx = x1 < x2 ? 1 : -1;
    int sy = y1 < y2 ? 1 : -1;

    
    boolean raid = dy > dx;
    if (raid) {
        int temp = dx;
        dx = dy;
        dy = temp;
    }
    
    int r = dx / 2;
    int x = x1;
    int y = y1;
    
    pixels.add(new Pixel(x, y));
    
    for (int i = 0; i < dx; i++) {
        r += dy;
        
        if (r >= dx) {
            r -= dx;
            if (raid) {
                x += sx;
            } else {
                y += sy;
            }
        }
        
        if (raid) {
            y += sy;
        } else {
            x += sx;
        }
        
        pixels.add(new Pixel(x, y));
    }
    
    return pixels.toArray(new Pixel[0]);
  }

  /** Fournit les pixels du segment joignant le pixel a un autre.
   * @param p Le pixel d'arrivee.
   * @param eq Equilibrage du trace (0 = equilibre, -1 = inf, 1 = sup).
   * @return La sequence de pixels du segment.
   */
  public Pixel[] tracerSegment (Pixel p, int eq)
  {
    return (tracerSegment (p));
  }

  /** Fournit les pixels du cercle dont ce pixel est le centre.
   * @param rayon rayon du cercle.
   * @return L'ensemble des pixels du cercle.
   */
  public Pixel[] tracerCercle (int rayon)
  {
    Pixel[] pts = {this, new Pixel (x + rayon, y)};
    return (pts);
  }
}
