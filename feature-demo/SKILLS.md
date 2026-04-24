# feature-demo/SKILLS.md

Skills for the demo module.

---

## Skill: Add Component Demo

Use when demonstrating a component from `ftt-ui-lib`.

### Inputs

```markdown
component = "FTTButton"
```

### Generate

- Demo composable
- Sample state/actions
- Preview if useful

### Rules

- Import the component from `ftt-ui-lib`.
- Do not duplicate component implementation.
- Show common states:
  - default
  - disabled
  - loading/error/selected if supported
- Keep sample text generic.

---

## Skill: Add Demo Screen

Use when creating a screen that displays multiple components.

### Rules

- Group components clearly.
- Keep state simple and local.
- Do not use production business logic.
- Use the library theme.
