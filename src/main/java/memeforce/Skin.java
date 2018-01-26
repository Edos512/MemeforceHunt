package memeforce;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import static memeforce.Palette.*;

public enum Skin {
	THINKING ("Thinking (fatmanspanda)", "thinking", GREEN),
	SCREAM ("Scream (Zarby89)", "scream", BLUE),
	BENANA ("Benana (ajneb174)", "benana", GREEN),
	VEETORP ("Duck (Veetorp)", "veetorp", GREEN),
	BOB ("Bob (Karkat | mmxbass)", "bob", GREEN),
	TEA ("Tea (ChristosOwen)", "tea", RED),
	PEACH ("Peach (ChelseyxLynn)", "peach", RED),
	PUG  ("Pug (Andy)", "pug", BLUE),
	BLEH ("BLEH (Andy)", "bleh", GREEN),
	BIRB ("Birb (Kelpsey)", "birb", GREEN),
	COFFEE ("Coffee (WillardJBradley)", "coffee", RED),
	GLACEON ("Glaceon (Glaceon)", "glaceon", BLUE),
	HONK ("Honk (TheDragonFeeney)", "honk", GREEN),
	SNES_LOGO ("SNES logo", "snes", GREEN),
	SNES_CONTROLLER ("SNES controller", "snescontroller", RED),
	LINK_FACE ("Wanted criminal", "linkface", BLUE),
	TRIFORCE ("Triforce", "triforce", GREEN),
	BEE ("Bee", "bee", GREEN),
	BIG_20 ("Big 20", "big20", RED),
	BOOTS ("Pegasus boots", "boots", RED),
	BROCCOLI ("Broccoli", "broccoli", GREEN),
	CHEST ("Chest", "chest", GREEN),
	CUCCO ("Cucco", "cucco", RED),
	DWARF ("Dwarf", "dwarf", BLUE),
	FAIRY ("Fairy", "fairy", BLUE),
	ICE_ROD ("Ice rod", "icerod", BLUE),
	MEAT ("Meat", "meat", RED),
	MAIL ("Green mail", "mail", GREEN),
	POT ("Pot", "pot", BLUE),
	PUFF ("Arrghus puff", "puff", BLUE),
	QUACK ("Swag Duck", "quack", GREEN),
	TILE ("Tile", "tile", BLUE),
	VITREOUS ("Vitreous", "vitreous", GREEN),
	WOODFELLA ("Woodfella", "woodfella", BLUE),
	SQUAREFORCE ("Squareforce piece", "squareforce", GREEN),
	PRESENT ("Festive present", "present", GREEN),
	SIX_NINE ("69", "69", GREEN),
	COMMON_MAGIC ("Common magic", "commonmagic", GREEN),
	ZERO_BOMBS ("No bombs", "nobomb", GREEN),
	NO_SILVERS ("No silvers", "noag", RED),
	JOY_PENDANT ("Joy pendant", "joypendant", BLUE),
	KINSTONE ("Kinstone", "kinstone", GREEN),
	GOLDEN_LEAF ("Golden leaf", "leaf", GREEN),
	SECRET_SHELL ("Secret shell", "shell", BLUE),
	NECKLACE ("Mermaid's necklace", "necklace", RED),
	MARIMBA ("Wind marimba", "marimba", BLUE),
	BANANA ("Banana", "banana", GREEN),
	BRA ("Pink bra", "bra", BLUE),
	ORE_CHUNK ("Ore chunk", "ore", RED),
	FORK ("Triumph fork", "fork", GREEN),
	Z1_LINK ("Z1 Link", "z1link", GREEN),
	Z1_OLD_MAN ("Z1 Old man", "z1oldman", GREEN),
	NAVI ("Navi", "navi", BLUE),
	SKULLTULA ("Skulltula", "skulltula", GREEN),
	PIKACHU ("Pikachu", "pikachu", GREEN),
	MARILL ("Marill doll", "marill", BLUE),
	POKEBALL ("Pokéball", "pokeball", RED),
	POKEMON_ICON ("Pokémon icon", "pokeicon", RED),
	OH_MY ("!", "ohmy", RED),
	SHARD ("Red shard", "shard", RED),
	EGG ("Egg", "egg", RED),
	COIN ("Coin", "coin", BLUE),
	ONE_UP ("1-up", "1up", GREEN),
	MOON ("Power moon", "moon", GREEN),
	STAR ("Power star", "star", GREEN),
	FEATHER ("Feather", "feather", BLUE),
	YOSHI ("Baby yoshi", "yoshi", RED),
	Q_BLOCK ("? Block", "qblock", GREEN),
	FORTRESS ("Fortress", "fortress", RED),
	KOOPA ("Koopa Kid", "koopa", BLUE),
	SHINE ("Shine sprite", "shine", GREEN),
	PARASOL ("Parasol", "parasol", RED),
	TOP_HAT ("Top hat", "tophat", RED),
	TWISTER ("Twister", "twister", BLUE),
	GHOST ("Ghost", "ghost", BLUE),
	BONKERS ("Bonkers", "bonkers", BLUE),
	PHAN_PHAN ("Phan Phan", "phanphan", RED),
	MASTER_HAND ("Master Hand", "masterhand", BLUE),
	WHEELIE ("Wheelie", "wheelie", RED),
	KIRBY_MAP ("Map (Kirby)", "kirbymap", GREEN),
	KIRBY_MUSIC ("Music sheet (Kirby)", "kirbymusic", RED),
	CUBE ("Cube", "cube", GREEN),
	MISSILE_TANK ("Missile tank", "missiletank", RED),
	EMERALD ("Chaos emerald", "emerald", GREEN),
	RING ("Ring", "ring", GREEN),
	RABITE ("Rabite", "rabite", GREEN),
	DRAGON_BALL ("Dragon ball", "dragonball", GREEN),
	TRASH_CAN ("Trash can", "trashcan", RED),
	PAINTING ("Pretty painting", "painting", BLUE),
	PLANET ("Planet model", "planet", BLUE),
	BEER ("Beer", "beer", GREEN),
	PIZZA ("Pizza", "pizza", GREEN),
	PIZZA_SLICE ("Pizza slice", "pizzaslice", GREEN),
	COOKIE ("Cookie", "cookie", BLUE),
	CANDY ("Candy", "candy", RED),
	B ("[B]", "B", RED),
	POOP ("Poop", "poop", RED),
	PYTHON ("Python logo", "python", BLUE),
	JPG ("Broken image", "jpg", RED),
	E404 ("Image not found", "E404", GREEN),
	;

	private final String name;
	private final String fileName;
	private final Palette p;
	private final byte[] data;
	private final BufferedImage preview;
	private final ImageIcon ico;
	private final ImageIcon icoSmall;

	private Skin(String name, String fileName, Palette p) {
		this.name = name;
		this.fileName = fileName;
		this.p = p;
		InputStream temp;
		ArrayList<Byte> btemp = new ArrayList<Byte>();
		temp = Skin.class.getResourceAsStream(
				String.format("/gfx/%s.gfx", fileName));
		int r = 0;
		do {
			try {
				r = temp.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (r == -1) { break; }
			btemp.add((byte) r);
		} while (r != -1);

		int l = btemp.size();
		int i = 0;
		data = new byte[l];
		for (Byte b : btemp) {
			data[i++] = b;
		}

		BufferedImage itemp;
		try {
			itemp = ImageIO.read(Skin.class.getResourceAsStream(
					String.format("/previews/%s.png", fileName)));
		} catch (IOException e) {
			itemp = new BufferedImage(16, 16, BufferedImage.TYPE_4BYTE_ABGR);
		}
		preview = new BufferedImage(32, 32, BufferedImage.TYPE_4BYTE_ABGR);
		Graphics2D g = preview.createGraphics();

		g.scale(2, 2);
		g.drawImage(itemp, 0, 0, null);
		g.dispose();
		ico = new ImageIcon(preview);
		icoSmall = new ImageIcon(itemp);
	}

	public String toString() {
		return name;
	}

	public ImageIcon getImageIcon() {
		return ico;
	}

	public ImageIcon getImageIconSmall() {
		return icoSmall;
	}

	public byte[] getData() {
		return data;
	}

	public BufferedImage getImage() {
		return preview;
	}

	public byte getPalette() {
		return p.b;
	}

	public byte getPaletteOW() {
		return p.bOW;
	}
}