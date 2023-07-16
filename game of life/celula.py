class Cell():
    def __init__(self, condition, neighbors):
        self.cell_condition = condition
        self.neighbors = neighbors

    def deadAlive(self):
        if self.cell_condition == 1:
            if self.neighbors.count(1) > 3:
                # print("dead")
                return 0
            elif self.neighbors.count(1) < 2:
                # print("dead")
                return 0
            elif self.neighbors.count(1) >= 2:
                # print("alive")
                return 1
            
        elif self.cell_condition == 0:
            if self.neighbors.count(1) == 3:
                # print("alive")
                return 1
        return 0

def add_top_left(neighbors_list, display, row, index):
    neighbors_list.append(display[row][index+1])
    neighbors_list.append(display[row+1][index])
    neighbors_list.append(display[row+1][index+1])

def add_top_right(neighbors_list, display, row, index):
    neighbors_list.append(display[row][index-1])
    neighbors_list.append(display[row+1][index-1])
    neighbors_list.append(display[row+1][index])

def add_top_row(neighbors_list, display, row, index):
    neighbors_list.append(display[row][index-1])
    neighbors_list.append(display[row+1][index-1])
    add_top_left(neighbors_list, display, row, index)

def add_all(neighbors_list, display, row, index):
    neighbors_list.append(display[row-1][index-1])
    neighbors_list.append(display[row-1][index])
    neighbors_list.append(display[row-1][index+1])
    add_top_row(neighbors_list, display, row, index)

def add_bottom_left(neighbors_list, display, row, index):
    neighbors_list.append(display[row-1][index])
    neighbors_list.append(display[row-1][index+1])
    neighbors_list.append(display[row][index+1])

def add_bottom_right(neighbors_list, display, row, index):
    neighbors_list.append(display[row-1][index-1])
    neighbors_list.append(display[row-1][index])
    neighbors_list.append(display[row][index-1])

def add_bottom_row(neighbors_list, display, row, index):
    neighbors_list.append(display[row-1][index-1])
    neighbors_list.append(display[row][index-1])
    add_bottom_left(neighbors_list, display, row, index)

def add_left(neighbors_list, display, row, index):
    add_bottom_left(neighbors_list, display, row, index)
    neighbors_list.append(display[row+1][index])
    neighbors_list.append(display[row+1][index+1])

def add_right(neighbors_list, display, row, index):
    add_bottom_right(neighbors_list, display, row, index)
    neighbors_list.append(display[row+1][index-1])
    neighbors_list.append(display[row+1][index])

gen = 1
screen = [
    [0, 1, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 1, 0, 0, 0, 0, 0, 0],
    [1, 1, 1, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0]
    ]

print(f"{gen}° gen:")
print(*screen,sep="\n")

input('Press "any" key to star\n')
while True:
    new_screen = []
    for index_row, row in enumerate(screen):
        next_gen = []
        for index_number, number in enumerate(row):
            cell_neighbors = []

            # Trata a primeira linha
            if index_row == 0 and index_number == 0:
                add_top_left(cell_neighbors, screen, index_row, index_number)

            elif index_row == 0 and index_number == len(row)-1:
                add_top_right(cell_neighbors, screen, index_row, index_number)
                
            elif index_row == 0:
                add_top_row(cell_neighbors, screen, index_row, index_number)
                
            # Trata a ultima linha
            elif row == screen[-1] and index_number == 0:
                add_bottom_left(cell_neighbors, screen, index_row, index_number)
            
            elif index_row == len(screen)-1 and index_number == len(row)-1:
                add_bottom_right(cell_neighbors, screen, index_row, index_number)
                
            elif index_row == len(screen)-1:
                add_bottom_row(cell_neighbors, screen, index_row, index_number)
            
            # Trata as laterais
            elif index_number == 0:
                add_left(cell_neighbors, screen, index_row, index_number)
                
            elif index_number == len(row)-1:
                add_right(cell_neighbors, screen, index_row, index_number)
            
            else:
                add_all(cell_neighbors, screen, index_row, index_number)
                        
            # print(f"Linha: {index_row} | Celula: {number} | Vizinhos: {cell_neighbors}")
            cell = Cell(number, cell_neighbors)
            next_gen.append(cell.deadAlive())
        new_screen.append(next_gen)

    gen += 1
    screen = new_screen

    print(f"{gen}° gen:")
    print(*screen, sep="\n")

    input('Press "any" key to keep going\n')